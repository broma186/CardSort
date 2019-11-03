package com.example.cardsort.data

class CompareObjects {

    companion object : Comparator<Card> {

        override fun compare(card1: Card, card2: Card): Int {
            if (card1.arrival.equals(card2.destination)) {
                return -1
            } else {
                return 1
            }
        }
    }
}