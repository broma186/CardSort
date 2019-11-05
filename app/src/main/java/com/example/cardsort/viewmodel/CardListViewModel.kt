package com.example.cardsort.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardsort.data.Card
import com.example.cardsort.data.CardRepository
import com.example.cardsort.data.TransPortType
import com.example.cardsort.utils.SORT_ITERATION_MAX
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.*
import javax.inject.Inject

class CardListViewModel @Inject constructor(val cardRepository: CardRepository) : ViewModel() {

    val cardLiveData = MutableLiveData<List<Card>>()

    init {
        generateCards()
        getCards()
    }

    /*
    Create hardcoded cards and add them to the database using the repository dependency.
     */
    fun generateCards() {

        val cards = listOf<Card>(
            Card(1, TransPortType.FLIGHT.transPortType, "Girona Airport",
                "London", "45B", "3A", 344),
            Card(2, TransPortType.BUS.transPortType, "Barcelona",
                "Girona Airport", null, null, null),
            Card(3, TransPortType.FLIGHT.transPortType, "London",
                "New York JFK", "22", "7B", null),
            Card(4, TransPortType.TRAIN.transPortType, "Madrid",
                "Barcelona", null, "45B", null)
        )
        cardRepository.writeCards(cards)
    }

    // Assign the cards written to the repository to live data instance used for the recycler view list.
    // This will notify the activity using an oberver that the unsorted data is ready to be displayed.
    fun getCards() {
        cardLiveData.value = cardRepository.getCards()
    }

    // Gets the repository cards and runs my sorting algorithm multiple times to ensure all items are
    // correctly sorted. Currently I am using 4 sort iterations.
    fun getSortedCards() {

        val cards = cardRepository.getCards()

        while (isSorted(cards) == false) {
            sort(cards)
        }

        cardLiveData.value = cards
    }

    // Sorting algorithm for cards.
    fun sort(cards : List<Card>) {
        for (i in cards.indices) {
            val current = cards.get(i)
            for (j in cards.indices) {
                val next = cards.get(j)
                if (current.arrival.equals(next.destination)) {
                    val indexOfCurrent = cards.indexOf(current)
                    val indexOfNext = cards.indexOf(next)
                    if (indexOfCurrent > indexOfNext + 1) {
                        Collections.rotate(cards.subList(indexOfNext, indexOfCurrent + 1), -1)
                    } else {
                        Collections.rotate(cards.subList(indexOfCurrent, indexOfNext + 1), -1)
                    }
                }
            }
        }
    }

    fun isSorted(cards : List<Card>) : Boolean {
        var sorted = true
        for (i in 0 until cards.size - 1) {
            val current = cards.get(i)
            val next = cards.get(i + 1)
            if (!current.destination.equals(next.arrival)) {
                return false
            }
        }
        return true
    }
}