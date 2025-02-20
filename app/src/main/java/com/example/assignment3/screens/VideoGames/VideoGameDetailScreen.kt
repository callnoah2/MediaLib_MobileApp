package com.example.assignment3.screens.VideoGames

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewmodels.VideoGameViewModel

@Composable
fun VideoGameDetailScreen(navController: NavController, videoGameId: Int, viewModel: VideoGameViewModel = viewModel()) {
    val game = viewModel.getVideoGameById(videoGameId)

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