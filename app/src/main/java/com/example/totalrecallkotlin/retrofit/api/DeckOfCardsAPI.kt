package com.example.totalrecallkotlin.retrofit.api

import android.media.Image
import com.example.totalrecallkotlin.retrofit.pojo.CardCollection
import com.example.totalrecallkotlin.retrofit.pojo.Deck
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface DeckOfCardsAPI {

    @GET("deck/new/shuffle")
    fun getNewDeck(@Query("deck_count") deckCount: String): Call<Deck>

    @GET("deck/{id}/draw")
    fun getCards(@Path("id") id: String?, @Query("count") count: String): Call<CardCollection>

    @GET
    @Streaming
    fun getImage(@Url url: String): Call<ResponseBody>

}