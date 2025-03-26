package com.ramiro.castrejon.book.presentation.book_detail

import com.ramiro.castrejon.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
