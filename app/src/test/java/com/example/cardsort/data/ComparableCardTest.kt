package com.example.cardsort.data

import android.util.Log
import org.junit.Before
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList


class ComparableCardTest {

     val cards = arrayListOf<ComparableCard>(
         ComparableCard(1, TransPortType.FLIGHT.transPortType,
             "Girona Airport", "London", "45B", "3A", 344),
         ComparableCard(2, TransPortType.BUS.transPortType,
             "Barcelona", "Girona Airport", null, null, null),
         ComparableCard(3, TransPortType.FLIGHT.transPortType,
             "London", "New York JFK", "22", "7B", null),
         ComparableCard(4, TransPortType.TRAIN.transPortType,
             "Madrid", "Barcelona", null, "45B", null),
         ComparableCard(5, TransPortType.FLIGHT.transPortType,
             "Madagascar", "Madrid", null, "32C", 45),
         ComparableCard(6, TransPortType.FLIGHT.transPortType,
             "New York JFK", "Jerusalem", null, "27A", 22)
    )



    @Test
    fun sortCards() {

        /*val sortedList = cards.sortedWith(compareBy({ it.arrival }, { it.destination }))
        sortedList.forEach() {
            Log.d("TEST", it.arrival + " > " + it.destination)
        }*/
        /*
              Girona Airport -- > London

             "Barcelona --> Girona Airport"

             "London --> New York JFK"

             "Madrid --> Barcelona"

             "Madagascar --> Madrid"

             "New York JFK --> Jerusalem"
         */
        val unsortedList = arrayListOf<ComparableCard>()
        for (i in cards.indices) {
            val current = cards.get(i)

            for (j in cards.indices) {
                val next = cards.get(j)

                if (current.arrival.equals(next.destination)) {
                    Collections.swap(cards, cards.indexOf(current), cards.indexOf(next))

                    val indexOfCurrent = cards.indexOf(current)
                    val indexOfNext = cards.indexOf(next)

                        //Collections.rotate(list.subList(j, k+1), -1)
                        //Collections.rotate(cards.subList(0, 1))
                    Collections.rotate(cards.subList(indexOfCurrent, indexOfNext + 1), indexOfNext)

                }
            }
        }


        cards.forEach() {
            Log.d("TEST", it.arrival + " > " + it.destination)
        }
    }

    object Log {
        fun d(tag: String, msg: String): Int {
            println("DEBUG: $tag: $msg")
            return 0
        }

        fun i(tag: String, msg: String): Int {
            println("INFO: $tag: $msg")
            return 0
        }

        fun w(tag: String, msg: String): Int {
            println("WARN: $tag: $msg")
            return 0
        }

        fun e(tag: String, msg: String): Int {
            println("ERROR: $tag: $msg")
            return 0
        }
    }
}

