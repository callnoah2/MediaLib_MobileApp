package com.example.assignment3.screens.VideoGames

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.models.VideoGame
import com.example.assignment3.viewModels.VideoGameViewModel
import com.example.assignment3.viewModels.MainViewModel

@Composable
fun CreateVideoGameScreen(navController: NavController, viewModel: VideoGameViewModel = viewModel(), mainViewModel: MainViewModel = viewModel()) {
    var title by remember { mutableStateOf("") }
    var developer by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var platform by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = developer,
            onValueChange = { developer = it },
            label = { Text("Developer") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = genre,
            onValueChange = { genre = it },
            label = { Text("Genre") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = rating,
            onValueChange = { rating = it },
            label = { Text("Rating") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = platform,
            onValueChange = { platform = it },
            label = { Text("Platform") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Notes") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (title.isNotEmpty() && developer.isNotEmpty() && genre.isNotEmpty() && rating.isNotEmpty() && platform.isNotEmpty()) {
                    viewModel.addVideoGame(
                        VideoGame(
                            id = viewModel.getNextId(),
                            title = title,
                            developer = developer,
                            genre = genre,
                            rating = rating,
                            platform = platform,
                            notes = notes
                        )
                    )
                    mainViewModel.incrementVideoGameCount()
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Save")
        }
    }
}