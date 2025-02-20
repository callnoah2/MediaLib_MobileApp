package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.assignment3.models.VideoGame

class VideoGameViewModel : ViewModel() {
    private val _videoGames = MutableStateFlow<List<VideoGame>>(emptyList())
    val videoGames: StateFlow<List<VideoGame>> = _videoGames

    fun addVideoGame(videoGame: VideoGame) {
        viewModelScope.launch {
            _videoGames.value = _videoGames.value + videoGame
        }
    }

    fun getNextId(): Int {
        return _videoGames.value.size + 1
    }

    fun getVideoGameById(id: Int): VideoGame? {
        return _videoGames.value.find { it.id == id }
    }
}