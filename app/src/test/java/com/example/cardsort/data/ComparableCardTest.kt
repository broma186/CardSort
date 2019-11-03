package com.example.cardsort.data

import android.util.Log
import org.junit.Before
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList


class ComparableCardTest {

     val cards = arrayListOf<ComparableCard>(
         ComparableCard(1, TransPortType.FLIGHT.transPortType, "Girona Airport",
            "London", "45B", "3A", 344),
         ComparableCard(2, TransPortType.BUS.transPortType, "Barcelona",
            "Girona Airport", null, null, null),
         ComparableCard(3, TransPortType.FLIGHT.transPortType, "London",
            "New York JFK", "22", "7B", null),
         ComparableCard(4, TransPortType.TRAIN.transPortType, "Madrid",
            "Barcelona", null, "45B", null),
         ComparableCard(5, TransPortType.FLIGHT.transPortType, "Madagascar",
             "Madrid", null, "32C", 45),
         ComparableCard(6, TransPortType.FLIGHT.transPortType, "New York JFK",
             "Jerusalem", null, "27A", 22)
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



    @Test
    fun sortCards() {




       /* var arrivalsAndDestinations = arrayListOf<String>()

        for (i in cards.indices) {
            val card = cards.get(i)
            arrivalsAndDestinations.add(card.arrival)
            arrivalsAndDestinations.add(card.destination)
        }
       val uniquePlaces = findUniques(arrivalsAndDestinations)

        // Find the card with the unique elements for start/end

        var startOrEndCards = arrayListOf<ComparableCard>()
        for(i in cards.indices) {
            val currentCard = cards.get(i)
            for (j in uniquePlaces.indices) {
                if (currentCard.arrival.equals(uniquePlaces.get(j))
                    || currentCard.destination.equals(uniquePlaces.get(j))) {
                    startOrEndCards.add(currentCard)
                }
            }
        }

        for (i in startOrEndCards.indices) {
            cards.remove(startOrEndCards.get(i))
        }*/

         cards.sort()
       /* val sortedList = cards.sortedWith(compareBy({ it.arrival },
            { it.destination }))
*/
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

