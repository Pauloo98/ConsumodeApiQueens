package br.com.consumodeapi.network

import br.com.consumodeapi.model.Queens
import retrofit2.http.GET

interface EndPointAPI {

    @GET("queens/all")
    suspend fun getResponseCharacter() : List<Queens>

}