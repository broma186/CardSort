package com.example.cardsort

import android.app.Application
import android.content.Context
import com.example.cardsort.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class CardSortApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var appComponent: AppComponent

    val context : Context = this

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector;
    }

}