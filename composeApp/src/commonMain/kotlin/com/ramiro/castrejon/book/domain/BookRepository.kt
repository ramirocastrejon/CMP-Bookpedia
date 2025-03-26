package com.ramiro.castrejon.book.domain

import com.ramiro.castrejon.core.domain.DataError
import com.ramiro.castrejon.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}