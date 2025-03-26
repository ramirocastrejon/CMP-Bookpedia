package com.ramiro.castrejon.book.presentation.book_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cocktailprojectcmp.composeapp.generated.resources.Res
import cocktailprojectcmp.composeapp.generated.resources.languages
import cocktailprojectcmp.composeapp.generated.resources.pages
import cocktailprojectcmp.composeapp.generated.resources.rating
import com.ramiro.castrejon.book.presentation.book_detail.components.BlurredImagedBackground
import com.ramiro.castrejon.book.presentation.book_detail.components.BookChip
import com.ramiro.castrejon.book.presentation.book_detail.components.TitledContent
import org.jetbrains.compose.resources.stringResource
import kotlin.math.round

@Composable
fun BookDetailScreenRoot(
    viewModel: BookDetailViewModel,
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BookDetailScreen(
        state = state,
        onAction = { action ->
            when(action) {
                is BookDetailAction.OnBackClick -> onBackClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
private fun BookDetailScreen(
    state: BookDetailState,
    onAction: (BookDetailAction) -> Unit
) {
    BlurredImagedBackground(
        imageUrl = state.book?.imageUrl,
        isFavorite = state.isFavorite,
        onFavoriteClick = {
            onAction(BookDetailAction.OnFavoriteClick)
        },
        onBackClick = {
            onAction(BookDetailAction.OnBackClick)
        },
        modifier = Modifier.fillMaxSize()
    ){
        if (state.book != null){
            Column(
                modifier = Modifier.widthIn(700.dp).fillMaxWidth().padding(vertical = 16.dp, horizontal = 24.dp).verticalScroll(
                    rememberScrollState()
                ), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = state.book.title,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
                Text(text = state.book.authors.joinToString(),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    state.book.averageRating?.let { rating ->
                        TitledContent(
                            title = stringResource(Res.string.rating)
                        ) {
                            BookChip {
                                Text(
                                    text = "${round(rating * 10) / 10.0}"
                                )
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = stringResource(Res.string.rating),
                                    tint = Color.Yellow
                                )
                            }
                        }
                    }
                    state.book.numPages?.let { pageCount ->
                        TitledContent(
                            title = stringResource(Res.string.pages)
                        ) {
                            BookChip {
                                Text(
                                    text = pageCount.toString()
                                )
                            }
                        }
                    }
                }
            }
        }

    }

}
