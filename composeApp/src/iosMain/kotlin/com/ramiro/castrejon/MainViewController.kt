package com.ramiro.castrejon

import androidx.compose.ui.window.ComposeUIViewController
import com.ramiro.castrejon.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }