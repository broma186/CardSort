package com.example.cardsort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.cardsort.databinding.ActivityBoardingCardBinding
import com.example.cardsort.viewmodel.CardListViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BoardingCardActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    lateinit var binding: ActivityBoardingCardBinding


    private lateinit var cardListViewModel : CardListViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityBoardingCardBinding>(this, R.layout.activity_boarding_card)

        cardListViewModel = ViewModelProviders.of(this, viewModelFactory)[CardListViewModel::class.java]

        setupCardList()

        observeList()

    }
}
