package com.example.cardsort.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cardsort.data.Card

class CardViewModel(card: Card) : ViewModel() {

    private val card = checkNotNull(card)

    val id
        get() = card.id

    val transportType
        get() = card.transportType

    val arrival
        get() = card.arrival

    val destination
        get() = card.destination

    val gate
        get() = card.gate

    val seat
        get() = card.seat

    val baggageCounterId
        get() = card.baggageCounterId
}