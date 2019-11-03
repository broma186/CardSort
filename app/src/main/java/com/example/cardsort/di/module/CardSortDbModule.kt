package com.example.todocreator.di.module

import android.content.Context
import androidx.room.Room
import com.example.cardsort.data.CardSortDao
import com.example.cardsort.utils.DATABASE_NAME
import com.example.gitrepositoryhub.data.CardSortDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object CardSortDbModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideCardSortDatabase(context: Context): CardSortDatabase {
        return Room.databaseBuilder(
            context,
            CardSortDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideCardSortDao(cardSortDatabase: CardSortDatabase): CardSortDao {
        return cardSortDatabase.cardSortDao()
    }
}