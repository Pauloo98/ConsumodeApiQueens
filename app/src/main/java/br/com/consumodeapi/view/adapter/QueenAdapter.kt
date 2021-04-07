package br.com.consumodeapi.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.consumodeapi.R
import br.com.consumodeapi.model.Queens
import br.com.consumodeapi.view.activity.QueenDetails
import com.squareup.picasso.Picasso

class QueenAdapter(
    private val list: List<Queens>,
    private val context: Context
) : RecyclerView.Adapter<QueenViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return QueenViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {
        val queens = list.elementAt(position)
        val url = queens.image_url.replace("http", "https")
        Picasso.get().load(url).into(holder.image)
        holder.name.text = queens.name
//        val queenImg = Picasso.get().load(url).into(holder.image)

        holder.image.setOnClickListener {
            val intent = Intent(it.context, QueenDetails::class.java)
            intent.putExtra("name", holder.name.text.toString())
            intent.putExtra("quote", queens.quote)
            intent.putExtra("imagem", url)
            it.context.startActivity(intent)

//            Toast.makeText(it.context, "Oi", Toast.LENGTH_LONG).show()
        }


    }


}