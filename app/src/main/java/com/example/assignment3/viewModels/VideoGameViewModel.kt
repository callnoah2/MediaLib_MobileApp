package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment3.models.VideoGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VideoGameViewModel : ViewModel() {
    private val _videoGames = MutableStateFlow<List<VideoGame>>(emptyList())
    val videoGames: StateFlow<List<VideoGame>> = _videoGames

    fun addVideoGame(videoGame: VideoGame) {
        viewModelScope.launch {
            _videoGames.value = _videoGames.value + videoGame
        }
    }

    fun getVideoGameById(id: Int): VideoGame? {
        return _videoGames.value.find { it.id == id }
    }

    fun getNextId(): Int {
        return (_videoGames.value.maxOfOrNull { it.id } ?: 0) + 1
    }
}