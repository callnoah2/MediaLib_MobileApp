package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment3.models.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    fun addMovie(movie: Movie) {
        viewModelScope.launch {
            _movies.value = _movies.value + movie
        }
    }

    fun getMovieById(id: Int): Movie? {
        return _movies.value.find { it.id == id }
    }

    fun getNextId(): Int {
        return (_movies.value.maxOfOrNull { it.id } ?: 0) + 1
    }
}