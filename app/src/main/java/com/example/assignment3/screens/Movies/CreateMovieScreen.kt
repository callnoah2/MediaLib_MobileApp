package com.example.assignment3.screens.Movies

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CreateMovieScreen(navController: NavController) {
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
                // Handle save action here
                navController.navigateUp()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}