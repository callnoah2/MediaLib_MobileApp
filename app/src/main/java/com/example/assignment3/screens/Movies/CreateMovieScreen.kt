package com.example.assignment3.screens.Movies

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.models.Movie
import com.example.assignment3.viewModels.MovieViewModel

@Composable
fun CreateMovieScreen(navController: NavController, viewModel: MovieViewModel = viewModel()) {
    var title by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var runtime by remember { mutableStateOf("") }
    var format by remember { mutableStateOf("") }
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
            value = runtime,
            onValueChange = { runtime = it },
            label = { Text("Runtime (minutes)") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = format,
            onValueChange = { format = it },
            label = { Text("Format") },
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
                if (title.isNotEmpty() && genre.isNotEmpty() && rating.isNotEmpty() && runtime.isNotEmpty() && format.isNotEmpty()) {
                    viewModel.addMovie(
                        Movie(
                            id = viewModel.getNextId(),
                            title = title,
                            genre = genre,
                            rating = rating,
                            runtime = runtime.toIntOrNull() ?: 0,
                            format = format,
                            notes = notes
                        )
                    )
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Save")
        }
    }
}