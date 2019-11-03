package com.example.cardsort.data

class ComparableCard(val id: Int,
                     val transportType: String,
                     val arrival: String,
                     val destination: String,
                     val gate: String?,
                     val seat: String?,
                     val baggageCounterId: Int?) : Comparable<ComparableCard> {

    override fun compareTo(other: ComparableCard): Int =
        compareValuesBy(this, other, { it.arrival},{ it.destination})

}