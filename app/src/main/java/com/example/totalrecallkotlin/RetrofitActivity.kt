package com.example.totalrecallkotlin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.totalrecallkotlin.retrofit.api.DeckOfCardsAPI
import com.example.totalrecallkotlin.retrofit.pojo.CardCollection
import com.example.totalrecallkotlin.retrofit.pojo.Deck
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit
    private lateinit var api: DeckOfCardsAPI
    private var deck: Deck? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        retrofit = Retrofit.Builder()
            .baseUrl("https://deckofcardsapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(DeckOfCardsAPI::class.java)
    }

    fun setLogs(s: String){
        logs.setText(s)
    }

    fun getDeck(v: View){
        var size = deck_size.text.toString()

        var call = api.getNewDeck(size)
        call.enqueue(object : Callback<Deck?> {
            override fun onFailure(call: Call<Deck?>, t: Throwable) {
                Toast.makeText(
                        applicationContext,
                        t.message,
                        Toast.LENGTH_SHORT
                )
                        .show()
            }

            override fun onResponse(call: Call<Deck?>, response: Response<Deck?>) {
                if (response.isSuccessful()){
                    deck = response.body()
                    setLogs(deck.toString())
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Unsuccessful response while getting Deck",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        })
    }

    fun getCards(v: View){
        var amount = card_amount.text.toString()

        var id = deck?.deckId
        if (id != null) {
            var call = api.getCards(id, amount)

            var cards: CardCollection?
            call.enqueue(object : Callback<CardCollection?> {
                override fun onFailure(call: Call<CardCollection?>, t: Throwable) {
                    Toast.makeText(
                            applicationContext,
                            t.message,
                            Toast.LENGTH_SHORT
                    )
                            .show()
                }

                override fun onResponse(
                    call: Call<CardCollection?>,
                    response: Response<CardCollection?>
                ) {
                    cards = response.body()
                    setLogs(cards.toString())
                }

            })
        }
    }
}