package com.example.assignment3.screens.BoardGames

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
import com.example.assignment3.models.BoardGame
import com.example.assignment3.viewModels.BoardGameViewModel

@Composable
fun BoardGameScreen(navController: NavController, viewModel: BoardGameViewModel = viewModel()) {
    val boardGames by viewModel.boardGames.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Board Games", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)) {
            items(boardGames) {
                Row {
                    Text(it.title)
                }
            }
        }

        Button(
            onClick = { navController.navigate("create_board_game") },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Add Board Game")
        }
    }
}

@Composable
fun BoardGameItem(game: BoardGame, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = game.title, style = MaterialTheme.typography.bodyLarge)
        }
    }
}