package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment3.models.BoardGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BoardGameViewModel : ViewModel() {
    private val _boardGames = MutableStateFlow<List<BoardGame>>(emptyList())
    val boardGames: StateFlow<List<BoardGame>> = _boardGames

    fun addBoardGame(boardGame: BoardGame) {
        viewModelScope.launch {
            _boardGames.value = _boardGames.value + boardGame
        }
    }

    fun getBoardGameById(id: Int): BoardGame? {
        return _boardGames.value.find { it.id == id }
    }

    fun getNextId(): Int {
        return _boardGames.value.maxOfOrNull { it.id }?.plus(1) ?: 0
    }
}