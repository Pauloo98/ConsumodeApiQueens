package br.com.consumodeapi.repository

import br.com.consumodeapi.model.Queens
import br.com.consumodeapi.network.EndPointAPI
import br.com.consumodeapi.network.RetrofitInit

class RepositoryApi {

    private var url = "https://www.nokeynoshade.party/api/"
    private var service = EndPointAPI::class

    private val serviceQueen = RetrofitInit(url).create(service)

    suspend fun getCharacterService(): List<Queens> = serviceQueen.getResponseCharacter()

}