package com.example.cardsort.data

import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardRepository @Inject constructor(
    private val cardSortDao: CardSortDao
) {

    fun getCards() = cardSortDao.getCards()

    fun writeCards(cards: List<Card>) = runBlocking {cardSortDao.insertAll(cards)}
}
