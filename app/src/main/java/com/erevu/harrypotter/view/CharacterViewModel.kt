package com.erevu.harrypotter.view

import com.erevu.harryporter.models.CharacterModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erevu.harrypotter.network.ApiService
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    var characterListResponse:List<CharacterModel> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val movieList = apiService.getCharacters()
                characterListResponse = movieList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}