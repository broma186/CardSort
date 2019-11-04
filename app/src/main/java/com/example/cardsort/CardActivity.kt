package com.example.cardsort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardsort.databinding.ActivityCardBinding
import com.example.cardsort.viewmodel.CardListViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import androidx.core.os.HandlerCompat.postDelayed
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Handler


class CardActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    private lateinit var adapter: CardAdapter
    lateinit var binding: ActivityCardBinding
    private lateinit var cardListViewModel: CardListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityCardBinding>(this, R.layout.activity_card)

        cardListViewModel = ViewModelProviders.of(this, viewModelFactory)[CardListViewModel::class.java]

        setupCardList()

        observeList()

        setSortListener()
    }

    fun setSortListener() {
        binding.setSortListener {

            binding.progress.visibility = View.VISIBLE
            binding.cardList.visibility = View.GONE

            cardListViewModel.getSortedCards()

            Handler().postDelayed(
                Runnable {
                    binding.progress.visibility = View.GONE
                    binding.cardList.visibility = View.VISIBLE
                    binding.sortState.text = getString(R.string.sorted_cards)
                },
                3000)
        }
    }

    fun setupCardList() {

        binding.cardList.layoutManager = LinearLayoutManager(this)
        adapter = CardAdapter()
        binding.cardList.adapter = adapter

    }

    fun observeList() {
        cardListViewModel.cardLiveData.observe(this, Observer { result ->
            adapter.submitList(result)
        })
    }
}
