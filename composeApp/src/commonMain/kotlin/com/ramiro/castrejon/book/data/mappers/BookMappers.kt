package com.ramiro.castrejon.book.data.mappers

import com.ramiro.castrejon.book.data.database.BookEntity
import com.ramiro.castrejon.book.data.dto.SearchedBookDto
import com.ramiro.castrejon.book.domain.Book

fun SearchedBookDto.toBook(): Book {
    return Book(
        id = id.substringAfterLast("/"),
        title = title,
        authors = authorNames ?: emptyList(),
        imageUrl = if (coverKey != null) {
            "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
        } else {
            "https://covers.openlibrary.org/b/olid/${coverAlternativeKey}-L.jpg"
        },
        description = null,
        averageRating = ratingsAverage,
        languages = languages ?: emptyList(),
        firstPublishYear = publishYear.toString(),
        numPages = numPagesMedian,
        numEditions = editionCount ?: 0,
        ratingCount = ratingsCount
    )
}

fun Book.toBookEntity(): BookEntity {
    return BookEntity(
        id = id,
        title = title,
        imageUrl = imageUrl,
        authors = authors,
        description = description,
        languages = languages,
        firstPublishYear = firstPublishYear,
        averageRating = averageRating,
        ratingCount = ratingCount,
        numPages = numPages,
        numEditions = numEditions
    )
}

fun BookEntity.toBook(): Book {
    return Book(
        id = id,
        title = title,
        imageUrl = imageUrl,
        authors = authors,
        description = description,
        languages = languages,
        firstPublishYear = firstPublishYear,
        averageRating = averageRating,
        ratingCount = ratingCount,
        numPages = numPages,
        numEditions = numEditions
    )
}