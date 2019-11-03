package com.example.cardsort.di

import com.example.cardsort.CardSortApplication
import com.example.gitrepositoryhub.di.module.ActivityBindingModule
import com.example.gitrepositoryhub.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

interface AppComponent {

    @Singleton
    @Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ActivityBindingModule::class,
            ViewModelModule::class
        ]
    )
    interface AppComponent : AndroidInjector<CardSortApplication>
}