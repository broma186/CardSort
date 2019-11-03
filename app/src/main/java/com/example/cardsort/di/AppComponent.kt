package com.example.cardsort.di

import android.app.Application
import com.example.cardsort.CardSortApplication
import com.example.gitrepositoryhub.di.module.ActivityBindingModule
import com.example.gitrepositoryhub.di.module.ViewModelModule
import com.example.todocreator.di.module.AppModule
import com.example.todocreator.di.module.CardSortDbModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

interface AppComponent {

    @Singleton
    @Component(
        modules = [
            AndroidSupportInjectionModule::class,
            AppModule::class,
            ActivityBindingModule::class,
            ViewModelModule::class,
            CardSortDbModule::class
        ]
    )
    interface AppComponent : AndroidInjector<CardSortApplication> {
        override fun inject(cardSortApplication: CardSortApplication)

        @Component.Builder
        interface Builder {
            @BindsInstance
            fun application(application: Application): Builder
            fun build(): AppComponent
        }
    }
}