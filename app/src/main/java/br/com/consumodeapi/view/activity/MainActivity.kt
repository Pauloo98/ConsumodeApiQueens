package br.com.consumodeapi.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.consumodeapi.R
import br.com.consumodeapi.model.Queens
import br.com.consumodeapi.view.adapter.QueenAdapter
import br.com.consumodeapi.viewmodel.ViewModelQueens

class MainActivity : AppCompatActivity() {
    private var results = mutableListOf<Queens>()

    val recycler by lazy { findViewById<RecyclerView>(R.id.recycler_home)}
    val viewModelCharacter by lazy { ViewModelProviders.of(this).get(ViewModelQueens::class.java)}
    lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        //config recycler
        val adapterCharacter = QueenAdapter(results, this)
        recycler.adapter = adapterCharacter
        val layoutManager = GridLayoutManager(this, 2)
        recycler.layoutManager = layoutManager

        viewModelCharacter.listMutableCharacter.observe(this, Observer {
            it?.let { itChar -> results.addAll(itChar) }
            adapterCharacter.notifyDataSetChanged()
        })
        viewModelCharacter.loading.observe(this, Observer {
            if(it){
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        })
        viewModelCharacter.errorMessage.observe(this, Observer {
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })
    }
}