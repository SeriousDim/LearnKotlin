package com.example.totalrecallkotlin

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.totalrecallkotlin.retrofit.api.DeckOfCardsAPI
import com.example.totalrecallkotlin.retrofit.pojo.CardCollection
import com.example.totalrecallkotlin.retrofit.pojo.Deck
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_retrofit.*
import okhttp3.ResponseBody
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

    fun checkPermission(){
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 100)
        }
    }

    fun setLogs(s: String){
        logs.setText(s)
    }

    fun getCardImage(link: String?){
        progress.visibility = View.VISIBLE
        Picasso.with(this).load(link!!)
                .into(imageView4, object: com.squareup.picasso.Callback {
                    override fun onSuccess() {
                        progress.visibility = View.GONE
                    }

                    override fun onError() {
                        progress.visibility = View.GONE
                    }
                })
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
                    if (response.isSuccessful){
                        cards = response.body()
                        setLogs(cards.toString())

                        var link = cards?.cards?.get(0)?.images?.png
                        if (link != null){
                            getCardImage(link)
                        } else{
                            Toast.makeText(
                                    applicationContext,
                                    "Error while loading card image",
                                    Toast.LENGTH_SHORT
                            )
                                    .show()
                        }
                    } else {
                        Toast.makeText(
                                applicationContext,
                                "Unsuccessful card loading",
                                Toast.LENGTH_SHORT
                        )
                                .show()
                    }
                }

            })
        }
    }
}