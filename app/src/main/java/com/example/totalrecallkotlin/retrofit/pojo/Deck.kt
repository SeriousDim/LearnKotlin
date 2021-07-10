package com.example.totalrecallkotlin.retrofit.pojo

import com.google.gson.annotations.SerializedName

data class Deck(
    var success: Boolean,
    @SerializedName("deck_id")
    var deckId: String,
    var remaining: Int,
    var shuffled: Boolean
)