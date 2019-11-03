package com.example.cardsort.di

import javax.inject.Scope

/*
    Created to ensure dependencies are attached to only the scope of the main repositories
    activity.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope
