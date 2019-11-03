package com.example.cardsort

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cardsort.data.Card
import com.example.cardsort.databinding.ListItemCardBinding
import com.example.cardsort.viewmodel.CardViewModel

class CardAdapter: ListAdapter<Card, CardAdapter.CardViewHolder>(CardDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_card, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        getItem(position).let { repositories ->
            with(holder) {
                bind(repositories)
            }
        }
    }

    class CardViewHolder(
        private val binding: ListItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init { }
        fun bind(card: Card) {
            with(binding) {
                viewModel = CardViewModel(card)
                executePendingBindings()
            }
        }
    }

    private class CardDiffCallback : DiffUtil.ItemCallback<Card>() {

        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.arrival == newItem.arrival
        }
    }
}