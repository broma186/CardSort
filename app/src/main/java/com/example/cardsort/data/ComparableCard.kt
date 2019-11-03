package com.example.cardsort.data

class ComparableCard(card : Card) : Comparable<Card> {

    val id: Int = card.id
    val transportType: String = card.transportType
    val arrival: String = card.arrival
    val destination: String = card.destination
    val gate: String? = card.gate
    val seat: String? = card.seat
    val baggageCounterId: Int? = card.baggageCounterId

    override fun compareTo(nextCard: Card): Int {
        if (destination.equals(nextCard.arrival)) {
            return 1
        } else {
            return -1
        }
    }
}