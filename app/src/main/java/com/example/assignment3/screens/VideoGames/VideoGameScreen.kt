package com.example.assignment3.screens.VideoGames

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewmodels.VideoGameViewModel
import com.example.assignment3.models.VideoGame

@Composable
fun VideoGameScreen(navController: NavController, viewModel: VideoGameViewModel = viewModel()) {
    val videoGames by viewModel.videoGames.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Video Games", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(videoGames) { game ->
                VideoGameItem(game = game, onClick = { navController.navigate("video_game/${game.id}") })
            }
        }

        Button(
            onClick = { navController.navigate("create_video_game") },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Add Video Game")
        }
    }
}

@Composable
fun VideoGameItem(game: VideoGame, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = game.title, style = MaterialTheme.typography.bodyLarge)
        }
    }
}