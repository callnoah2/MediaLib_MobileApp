package com.example.assignment3.screens.Books

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewModels.BookViewModel

@Composable
fun BookDetailScreen(navController: NavController, bookId: Int, viewModel: BookViewModel = viewModel()) {
    val book = viewModel.getBookById(bookId)

    if (book != null) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = book.title, style = MaterialTheme.typography.headlineLarge)
            Text(text = "by ${book.author}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Format: ${book.format}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Genre: ${book.genre}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Pages: ${book.numPages}", style = MaterialTheme.typography.bodyLarge)
        }
    } else {
        Text(text = "Book not found", style = MaterialTheme.typography.headlineLarge)
    }
}