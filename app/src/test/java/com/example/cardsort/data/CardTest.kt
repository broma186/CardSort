package com.example.cardsort.data

import android.util.Log
import org.junit.Before
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList


class CardTest {

     val cards = arrayListOf<Card>(
         Card(2, TransPortType.BUS.transPortType,
             "Barcelona", "Girona Airport", null, null, null),
         Card(3, TransPortType.FLIGHT.transPortType,
             "London", "New York JFK", "22", "7B", null),
         Card(4, TransPortType.TRAIN.transPortType,
             "Madrid", "Barcelona", null, "45B", null),
         Card(1, TransPortType.FLIGHT.transPortType,
             "Girona Airport", "London", "45B", "3A", 344)
    )


    fun sort() {
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

    @Test
    fun sortCards() {

        sort()
        sort()
        sort()
        sort()

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

