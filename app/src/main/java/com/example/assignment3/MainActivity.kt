package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment3.ui.theme.Assignment3Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.asFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.asFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val navController = rememberNavController()
                        AppNavHost(navController)
                    }
                }
            }
        }
    }
}

data class Movie(val id: Int, val title: String, val details: String)
data class Book(val id: Int, val title: String, val author: String, val details: String)
data class VideoGame(val id: Int, val title: String, val details: String)
data class BoardGame(val id: Int, val title: String, val details: String)

interface MovieRepository {
    fun getMovies(): List<Movie>
    fun getMovie(id: Int): Movie
    fun addMovie(movie: Movie)
}

class MovieRepositoryImpl : MovieRepository {
    private val movies = mutableListOf<Movie>()

    override fun getMovies() = movies
    override fun getMovie(id: Int) = movies.first { it.id == id }
    override fun addMovie(movie: Movie) {
        movies.add(movie)
    }
}

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    init {
        _movies.value = repository.getMovies()
    }

    fun addMovie(movie: Movie) {
        repository.addMovie(movie)
        _movies.value = repository.getMovies()
    }
}

@Composable
fun HomeScreen(navController: NavController, movieCount: Int, bookCount: Int, gameCount: Int, boardGameCount: Int) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Media Gallery", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        ButtonWithCount("Movies", movieCount) { navController.navigate("movies") }
        ButtonWithCount("Books", bookCount) { navController.navigate("books") }
        ButtonWithCount("Video Games", gameCount) { navController.navigate("video_games") }
        ButtonWithCount("Board Games", boardGameCount) { navController.navigate("board_games") }
    }
}

@Composable
fun ButtonWithCount(label: String, count: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        Text(text = "$label ($count)")
    }
}

@Composable
fun MoviesScreen(navController: NavController, viewModel: MovieViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val movies by viewModel.movies.observeAsState(emptyList())
    Column {
        movies.forEach { movie: Movie ->
            Text(text = movie.title, modifier = Modifier.clickable { navController.navigate("movie/${movie.id}") })
        }
        Button(onClick = { navController.navigate("create_movie") }) {
            Text("Add Movie")
        }
    }
}

@Composable
fun <T> LiveData<T>.observeAsState(initial: T): State<T> {
    val state = remember { mutableStateOf(initial) }
    val observer = rememberUpdatedState { value: T -> state.value = value }
    DisposableEffect(this) {
        val liveDataObserver = Observer<T> { observer.value(it) }
        observeForever(liveDataObserver)
        onDispose { removeObserver(liveDataObserver) }
    }
    return state
}
@Composable
fun CreateMovieScreen(navController: NavController) {
    // Define the UI for creating a movie
}

@Composable
fun MovieScreen(navController: NavController, movieId: Int) {
    // Define the UI for displaying a single movie's details
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                navController = navController,
                movieCount = 0,
                bookCount = 0,
                gameCount = 0,
                boardGameCount = 0
            )
        }
        composable("movies") { MoviesScreen(navController) }
        composable("create_movie") { CreateMovieScreen(navController) }
        composable("movie/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?.toInt() ?: 0
            MovieScreen(navController, movieId)
        }
        // Add other screens similarly
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Assignment3Theme {
        val navController = rememberNavController()
        HomeScreen(
            navController = navController,
            movieCount = 3,
            bookCount = 5,
            gameCount = 2,
            boardGameCount = 4
        )
    }
}