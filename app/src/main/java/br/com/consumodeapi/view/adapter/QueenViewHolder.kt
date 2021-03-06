package br.com.consumodeapi.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.consumodeapi.R

class QueenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.findViewById(R.id.imgcharacter_card)
    val name: TextView = itemView.findViewById(R.id.txt_card)
}