package br.com.consumodeapi.view.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.consumodeapi.R
import com.squareup.picasso.Picasso

class QueenDetails : AppCompatActivity() {

    val iv_queen by lazy {findViewById<ImageView>(R.id.iv_queen)}
    val tv_name by lazy {findViewById<TextView>(R.id.tv_name)}
    val tv_quote by lazy {findViewById<TextView>(R.id.tv_quote)}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.queen_details)

        val dados = intent.extras
        val queenName = dados?.getString("name")
        val queenQuote = dados?.getString("quote")
        val queenImg = dados?.getString("imagem")
        val imageQueenUrl = Picasso.get().load(queenImg).into(iv_queen)

        setTitle(queenName)
        

        tv_name.text = queenName
        tv_quote.text = queenQuote


    }

}