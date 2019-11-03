package com.example.gitrepositoryhub.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cardsort.viewmodel.CardListViewModel
import com.example.gitrepositoryhub.di.ViewModelKey
import com.example.gitrepositoryhub.viewmodels.CardViewModelFactory
import dagger.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/*
Binds the view model and the view model creator (factory) to the main activity in this case.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CardListViewModel::class)
    abstract fun bindRepositoriesViewModel(cardListViewModel: CardListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(cardViewModelFactory: CardViewModelFactory): ViewModelProvider.Factory

}
