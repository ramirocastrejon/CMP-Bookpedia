package com.ramiro.castrejon.book.data.network

import com.ramiro.castrejon.book.data.dto.SearchResponseDto
import com.ramiro.castrejon.book.domain.Book
import com.ramiro.castrejon.core.data.safeCall
import com.ramiro.castrejon.core.domain.DataError
import com.ramiro.castrejon.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
): RemoteBookDataSource {
    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?
    ): Result<SearchResponseDto, DataError.Remote>{
        return safeCall {
            httpClient.get(
                urlString = "https://openlibrary.org/search.json"
            ){
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter("fields", "key,title,language,cover_i,author_key,author_name,cover_edition_key,first_publish_year,ratings_average,ratings_count,number_of_pages_median,edition_count")
            }
        }
    }
}