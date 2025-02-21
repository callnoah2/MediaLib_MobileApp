package com.example.assignment3.screens.BoardGames

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewModels.BoardGameViewModel

@Composable
fun BoardGameDetailScreen(navController: NavController, boardGameId: Int, viewModel: BoardGameViewModel = viewModel()) {
    val game = viewModel.getBoardGameById(boardGameId)
    Log.d("FoundBoardGame", "game ID: $boardGameId")

    if (game != null) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = game.title, style = MaterialTheme.typography.headlineLarge)
            Text(text = "Players: ${game.minPlayers} - ${game.maxPlayers}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Category: ${game.type}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Notes: ${game.notes}", style = MaterialTheme.typography.bodyLarge)
        }
    } else {
        Text(text = "Game not found", style = MaterialTheme.typography.headlineLarge)
    }
}