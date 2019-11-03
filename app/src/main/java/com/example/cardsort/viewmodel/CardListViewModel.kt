package com.example.cardsort.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardsort.data.Card
import com.example.cardsort.data.CardRepository
import com.example.cardsort.data.TransPortType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
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

    fun sortCards() {

        val cards = cardLiveData.value


    }
}