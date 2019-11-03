package com.example.cardsort.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Card::class], version = 1, exportSchema = false)
abstract class CardSortDatabase : RoomDatabase() {
    abstract fun cardSortDao(): CardSortDao
}