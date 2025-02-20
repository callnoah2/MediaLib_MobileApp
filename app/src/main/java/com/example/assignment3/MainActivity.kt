package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.assignment3.ui.theme.Assignment3Theme
import com.example.assignment3.screens.HomeScreen
import com.example.assignment3.screens.Movies.MovieScreen
import com.example.assignment3.screens.Movies.CreateMovieScreen
import com.example.assignment3.screens.Movies.MovieDetailScreen
import com.example.assignment3.screens.Books.BookScreen
import com.example.assignment3.screens.Books.CreateBookScreen
import com.example.assignment3.screens.Books.BookDetailScreen
import com.example.assignment3.screens.VideoGames.VideoGameScreen
import com.example.assignment3.screens.VideoGames.CreateVideoGameScreen
import com.example.assignment3.screens.VideoGames.VideoGameDetailScreen
import com.example.assignment3.screens.BoardGames.BoardGameScreen
import com.example.assignment3.screens.BoardGames.CreateBoardGameScreen
import com.example.assignment3.screens.BoardGames.BoardGameDetailScreen
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = Destinations.Home()
                        ) {
                            //HOME
                            composable<Destinations.Home> {
                                HomeScreen(
                                    movieCount = 0,
                                    bookCount = 0,
                                    gameCount = 0,
                                    boardGameCount = 0,
                                    navController = navController
                                )
                            }
                            //MOVIES
                            composable<Destinations.Movie> {
                                MovieScreen(navController = navController)
                            }
                            composable<Destinations.CreateMovie> {
                                CreateMovieScreen(navController = navController)
                            }
                            composable<Destinations.MovieDetail> { backStackEntry ->
                                val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
                                MovieDetailScreen(
                                    movieId = movieId,
                                    navController = navController
                                )
                            }
                            //BOOKS
                            composable<Destinations.Book> {
                                BookScreen(navController = navController)
                            }
                            composable<Destinations.CreateBook> {
                                CreateBookScreen(navController = navController)
                            }
                            composable<Destinations.BookDetail> { backStackEntry ->
                                val bookId = backStackEntry.arguments?.getInt("bookId") ?: 0
                                BookDetailScreen(
                                    bookId = bookId,
                                    navController = navController
                                )
                            }
                            //VIDEO GAMES
                            composable<Destinations.VideoGame> {
                                VideoGameScreen(navController = navController)
                            }
                            composable<Destinations.CreateVideoGame> {
                                CreateVideoGameScreen(navController = navController)
                            }
                            composable<Destinations.VideoGameDetail> { backStackEntry ->
                                val videoGameId = backStackEntry.arguments?.getInt("videoGameId") ?: 0
                                VideoGameDetailScreen(
                                    videoGameId = videoGameId,
                                    navController = navController
                                )
                            }
                            //BOARD GAMES
                            composable<Destinations.BoardGame> {
                                BoardGameScreen(navController = navController)
                            }
                            composable<Destinations.CreateBoardGame> {
                                CreateBoardGameScreen(navController = navController)
                            }
                            composable<Destinations.BoardGameDetail> { backStackEntry ->
                                val boardGameId = backStackEntry.arguments?.getInt("boardGameId") ?: 0
                                BoardGameDetailScreen(
                                    boardGameId = boardGameId,
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}