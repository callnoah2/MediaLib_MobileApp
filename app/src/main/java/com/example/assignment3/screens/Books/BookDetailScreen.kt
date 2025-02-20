package com.example.assignment3.screens.Books

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewmodels.BookViewModel

@Composable
fun BookDetailScreen(navController: NavController, bookId: Int, viewModel: BookViewModel = viewModel()) {
    val book = viewModel.getBookById(bookId)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = book?.title ?: "Unknown Book", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = "Author: ${book?.author ?: "Unknown"}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "Details: ${book?.details ?: "No details available"}", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = 8.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Back")
        }
    }
}