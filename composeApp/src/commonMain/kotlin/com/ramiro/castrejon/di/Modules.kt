package com.ramiro.castrejon.di

import com.ramiro.castrejon.book.data.network.KtorRemoteBookDataSource
import com.ramiro.castrejon.book.data.network.RemoteBookDataSource
import com.ramiro.castrejon.book.data.repository.DefaultBookRepository
import com.ramiro.castrejon.book.domain.BookRepository
import com.ramiro.castrejon.book.presentation.SelectedBookViewModel
import com.ramiro.castrejon.book.presentation.book_list.BookListViewModel
import com.ramiro.castrejon.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
}