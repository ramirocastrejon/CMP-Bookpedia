package com.ramiro.castrejon.book.data.repository

import com.ramiro.castrejon.book.data.mappers.toBook
import com.ramiro.castrejon.book.data.network.RemoteBookDataSource
import com.ramiro.castrejon.book.domain.Book
import com.ramiro.castrejon.book.domain.BookRepository
import com.ramiro.castrejon.core.domain.DataError
import com.ramiro.castrejon.core.domain.Result
import com.ramiro.castrejon.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>{
        return remoteBookDataSource.searchBooks(query).map { dto -> dto.results.map { it.toBook() } }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        return remoteBookDataSource.getBookDetails(bookId).map { it.description }
    }
}