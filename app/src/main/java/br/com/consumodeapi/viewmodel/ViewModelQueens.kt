package br.com.consumodeapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.consumodeapi.model.Queens
import br.com.consumodeapi.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.UnknownHostException

class ViewModelQueens : ViewModel() {

    val listMutableCharacter = MutableLiveData<List<Queens>>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    private val repository = RepositoryApi()

    init {
        getAllCharacters()
    }

    fun getAllCharacters() = CoroutineScope(Dispatchers.IO).launch {
        loading.postValue(true)
        try {

            repository.getCharacterService().let { charactersResponse ->
                listMutableCharacter.postValue(charactersResponse)
                loading.postValue(false)
            }
        }catch (error: Throwable){
            loading.postValue(false)
            handleError(error)
        }
    }

    private fun handleError(error: Throwable) {
        when(error){
            is HttpException -> errorMessage.postValue("Erro de conexão código: ${error.code()}")
            is UnknownHostException -> errorMessage.postValue("Verifique sua conexão")
        }
    }
}