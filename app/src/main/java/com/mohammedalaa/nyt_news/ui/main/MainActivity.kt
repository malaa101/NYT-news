package com.mohammedalaa.nyt_news.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.google.accompanist.adaptive.calculateDisplayFeatures
import com.mohammedalaa.nyt_news.ui.NewsApp
import com.mohammedalaa.designsystem.theme.NYTnewsTheme
import com.mohammedalaa.navigation.MainContract
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NYTnewsTheme {
                val windowSize = calculateWindowSizeClass(this)
                val displayFeatures = calculateDisplayFeatures(this)
                val uiState = viewModel.state.collectAsState()

                NewsApp(
                    windowSize = windowSize,
                    displayFeatures = displayFeatures.toPersistentList(),
                    uiState = uiState.value,
                    closeDetailScreen = { viewModel.closeDetailScreen() },
                    onNewsItemSelected = { newsItem, contentType ->
                        viewModel.event(
                            MainContract.Event.SetNewsItem(
                                newsModel = newsItem,
                                contentType = contentType
                            )
                        )
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    NYTnewsTheme {
        NewsApp(
            windowSize = WindowSizeClass.calculateFromSize(DpSize(400.dp, 900.dp)),
            displayFeatures = persistentListOf(),
            uiState = MainContract.State(),
            closeDetailScreen = {},
        )
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true, widthDp = 700, heightDp = 500)
@Composable
fun NewsAppPreviewTablet() {
    NYTnewsTheme {
        NewsApp(
            windowSize = WindowSizeClass.calculateFromSize(DpSize(700.dp, 500.dp)),
            displayFeatures = persistentListOf(),
            uiState = MainContract.State(),
            closeDetailScreen = {},
        )
    }
}
