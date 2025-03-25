package com.ramiro.castrejon


import androidx.compose.runtime.*
import com.ramiro.castrejon.book.presentation.book_list.BookListScreenRoot
import com.ramiro.castrejon.book.presentation.book_list.BookListViewModel

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    BookListScreenRoot (
        viewModel = remember { BookListViewModel() },
        onBookClick = {

        }
    )
}