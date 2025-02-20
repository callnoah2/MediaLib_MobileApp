package com.example.assignment3.screens.BoardGames

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewModels.BoardGameViewModel

@Composable
fun BoardGameDetailScreen(navController: NavController, boardGameId: Int, viewModel: BoardGameViewModel = viewModel()) {
    val boardGame = viewModel.getBoardGameById(boardGameId)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = boardGame?.title ?: "Unknown Board Game", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "Min Players: ${boardGame?.minPlayers ?: "Unknown"}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "Max Players: ${boardGame?.maxPlayers ?: "Unknown"}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "Genre: ${boardGame?.type ?: "Unknown"}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "Notes: ${boardGame?.notes ?: "No notes available"}", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = 8.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Back")
        }
    }
}