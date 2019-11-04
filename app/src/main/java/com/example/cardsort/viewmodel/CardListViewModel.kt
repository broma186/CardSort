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

    fun getCards() {
        cardLiveData.value = cardRepository.getCards()
    }

    fun getSortedCards() {

        val cards = cardRepository.getCards()

        var i = 0
        while (i < SORT_ITERATION_MAX) {
            sort(cards)
            i++
        }

        cardLiveData.value = cards
    }

    // Sorting algorithm for cards
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
}