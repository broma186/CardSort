package com.example.cardsort.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "card",
    indices = [Index("id")]
)
data class Card(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int, // Keep the same so is replaced every auth download.
    @ColumnInfo(name = "transport_type") val transportType: String,
    @ColumnInfo(name = "arrival") val arrival: String,
    @ColumnInfo(name = "destination") val destination: String,
    @ColumnInfo(name = "gate") val gate: String?,
    @ColumnInfo(name = "seat") val seat: String?,
    @ColumnInfo(name = "baggage_counter_id") val baggageCounterId: Int?
)
