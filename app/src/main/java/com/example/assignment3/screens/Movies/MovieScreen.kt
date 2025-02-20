package com.example.assignment3.screens.Movies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewmodels.MovieViewModel
import com.example.assignment3.models.Movie

@Composable
fun MovieScreen(navController: NavController, viewModel: MovieViewModel = viewModel()) {
    val movies by viewModel.movies.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Movies", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(movies) { movie ->
                MovieItem(movie = movie, onClick = { navController.navigate("movie/${movie.id}") })
            }
        }

        Button(
            onClick = { navController.navigate("create_movie") },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Add Movie")
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = movie.title, style = MaterialTheme.typography.bodyLarge)
        }
    }
}