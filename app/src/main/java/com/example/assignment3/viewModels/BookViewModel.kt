package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment3.models.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books

    fun addBook(book: Book) {
        viewModelScope.launch {
            _books.value = _books.value + book
        }
    }

    fun getBookById(id: Int): Book? {
        return _books.value.find { it.id == id }
    }

    fun getNextId(): Int {
        return (_books.value.maxOfOrNull { it.id } ?: 0) + 1
    }
}