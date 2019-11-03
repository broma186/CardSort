package com.example.gitrepositoryhub.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cardsort.data.Card
import com.example.cardsort.data.CardSortDao

@Database(entities = [Card::class], version = 1, exportSchema = false)
abstract class CardSortDatabase : RoomDatabase() {
    abstract fun cardSortDao(): CardSortDao
}