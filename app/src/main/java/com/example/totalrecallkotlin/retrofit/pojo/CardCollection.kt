package com.example.totalrecallkotlin.retrofit.pojo

import com.google.gson.annotations.SerializedName

data class CardCollection(
    var success: Boolean,
    @SerializedName("deck_id")
    var deckId: String,
    var cards: List<Card>,
    var remaining: Int
)

data class Card(
    var code: String,
    var image: String,
    var images: Links,
    var value: String,
    var suit: String
)

data class Links(
    var svg: String,
    var png: String
)