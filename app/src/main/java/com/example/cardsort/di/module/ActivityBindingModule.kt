package com.example.gitrepositoryhub.di.module

import com.example.cardsort.CardActivity
import dagger.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
Allows injection to the repositories activity so all subseqeuent dependencies can
 be injected. A scope is set for the activity so it's dependencies cab annotated to
 work in it's scope.
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeCardActivity(): CardActivity
}
