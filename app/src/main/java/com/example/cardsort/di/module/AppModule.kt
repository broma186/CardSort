package com.example.cardsort.di.module

import android.app.Application
import android.content.Context
import com.example.cardsort.CardSortApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
object AppModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideCardSortApplication(cardSortApplication: CardSortApplication): CardSortApplication {
        return cardSortApplication
    }
}