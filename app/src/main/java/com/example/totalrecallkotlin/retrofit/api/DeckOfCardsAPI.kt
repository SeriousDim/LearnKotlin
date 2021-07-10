package com.example.totalrecallkotlin.retrofit.api

import com.example.totalrecallkotlin.retrofit.pojo.CardCollection
import com.example.totalrecallkotlin.retrofit.pojo.Deck
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DeckOfCardsAPI {

    @GET("deck/new/shuffle")
    fun getNewDeck(@Query("deck_count") deckCount: String): Call<Deck>

    @GET("deck/{id}/draw")
    fun getCards(@Path("id") id: String?, @Query("count") count: String): Call<CardCollection>

}