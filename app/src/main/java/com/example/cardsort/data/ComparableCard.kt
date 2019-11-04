package com.example.cardsort.data

import android.util.Log

class ComparableCard(val id: Int,
                     val transportType: String,
                     val arrival: String,
                     val destination: String,
                     val gate: String?,
                     val seat: String?,
                     val baggageCounterId: Int?) : Comparable<ComparableCard> {

    override fun compareTo(other: ComparableCard): Int {
        return compareValuesBy(this, other, { it.arrival }, { it.destination })
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