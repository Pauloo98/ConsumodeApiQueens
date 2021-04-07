package br.com.consumodeapi.model

data class Queens(
    val id: Int,
    val image_url: String,
    val missCongeniality: Boolean,
    val name: String,
    val quote: String,
    val winner: Boolean
)


// DEPOIS ADD OS SERIALIZED