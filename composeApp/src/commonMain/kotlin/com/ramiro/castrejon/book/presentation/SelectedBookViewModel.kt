package com.ramiro.castrejon.book.presentation

import androidx.lifecycle.ViewModel
import com.ramiro.castrejon.book.domain.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

//this is a shared view model to share data between navigation
class SelectedBookViewModel: ViewModel() {

    private val _selectedBook = MutableStateFlow<Book?>(null)
    val selectedBook = _selectedBook.asStateFlow()

    fun onSelectBook(book: Book?) {
        _selectedBook.value = book
    }
}