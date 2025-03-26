package com.ramiro.castrejon

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.ramiro.castrejon.di.initKoin
import org.koin.core.context.startKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Bookpedia",
        ) {
            App()
        }
    }
}