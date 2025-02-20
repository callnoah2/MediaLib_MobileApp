package com.example.assignment3.screens.Movies

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewmodels.MovieViewModel

@Composable
fun MovieDetailScreen(navController: NavController, movieId: Int, viewModel: MovieViewModel = viewModel()) {
    val movie = viewModel.getMovieById(movieId)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = movie?.title ?: "Unknown Movie", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "Details: ${movie?.details ?: "No details available"}", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = 8.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Back")
        }
    }
}