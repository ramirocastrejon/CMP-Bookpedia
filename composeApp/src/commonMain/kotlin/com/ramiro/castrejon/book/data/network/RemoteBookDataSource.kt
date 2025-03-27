package com.ramiro.castrejon.book.data.network

import com.ramiro.castrejon.book.data.dto.BookWorkDto
import com.ramiro.castrejon.book.data.dto.SearchResponseDto
import com.ramiro.castrejon.core.domain.DataError
import com.ramiro.castrejon.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(
        bookWorkId: String
    ): Result<BookWorkDto, DataError.Remote>
}