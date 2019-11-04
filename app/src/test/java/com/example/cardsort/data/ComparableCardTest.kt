package com.example.cardsort.data

import android.util.Log
import org.junit.Before
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList


class ComparableCardTest {

     val cards = arrayListOf<ComparableCard>(
         ComparableCard(2, TransPortType.BUS.transPortType,
             "Barcelona", "Girona Airport", null, null, null),
         ComparableCard(3, TransPortType.FLIGHT.transPortType,
             "London", "New York JFK", "22", "7B", null),
         ComparableCard(4, TransPortType.TRAIN.transPortType,
             "Madrid", "Barcelona", null, "45B", null),
         ComparableCard(1, TransPortType.FLIGHT.transPortType,
             "Girona Airport", "London", "45B", "3A", 344)



/*
    Girona Airport -- > London

             "Barcelona --> Girona Airport"

             "London --> New York JFK"

             "Madrid --> Barcelona"

             "Madagascar --> Madrid"

             "New York JFK --> Jerusalem"
 */





     
    )

    fun findUniques(list:ArrayList<String>) : ArrayList<String> {
        val resultList = arrayListOf<String>()
        val hm = HashMap<String, Int>()

        for (i in list) {
            val j = hm[i]
            hm[i] = if ((j == null)) 1 else j!! + 1
        }
        for (`val` in hm.entries) {
            // Log.d("TEST", "Element " + `val`.key + " " + "occurs" + ": " + `val`.value + " times")
            if (`val`.value == 1) {
                resultList.add(`val`.key)
            }
        }
        return resultList
    }

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
        /*
              Girona Airport -- > London

             "Barcelona --> Girona Airport"

             "London --> New York JFK"

             "Madrid --> Barcelona"

             "Madagascar --> Madrid"

             "New York JFK --> Jerusalem"
         */


        sort()
        sort()
        sort()
        sort()
        if (cards.size % 2 == 0) {
           // Collections.rotate(cards, 1)

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

