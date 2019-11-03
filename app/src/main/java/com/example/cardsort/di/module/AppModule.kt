package com.example.todocreator.di.module

import android.app.Application
import android.content.Context
import com.example.cardsort.CardSortApplication
import com.example.gitrepositoryhub.di.module.ViewModelModule
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
    fun provideTodoApplication(cardSortApplication: CardSortApplication): CardSortApplication {
        return cardSortApplication
    }
}