package com.example.assignment3.screens.BoardGames

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewmodels.BoardGameViewModel

@Composable
fun BoardGameDetailScreen(navController: NavController, gameId: Int, viewModel: BoardGameViewModel = viewModel()) {
    val game = viewModel.getBoardGameById(gameId)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = game?.title ?: "Unknown Game", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))

        Text(text = "Details: ${game?.details ?: "No details available"}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Back")
        }
    }
}