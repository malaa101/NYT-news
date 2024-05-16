package com.mohammedalaa.navigation.graph

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.window.layout.DisplayFeature
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane
import com.mohammedalaa.domain.model.NewsModel
import com.mohammedalaa.navigation.Destinations
import com.mohammedalaa.navigation.ext.parcelableData
import com.mohammedalaa.designsystem.util.ContentType
import com.mohammedalaa.navigation.MainContract
import com.mohammedalaa.newsdetails.MarketDetailRoute
import com.mohammedalaa.newslist.MarketListRoute
import kotlinx.collections.immutable.PersistentList

fun NavGraphBuilder.newsList(
    contentType: ContentType,
    displayFeature: PersistentList<DisplayFeature>,
    uiState: MainContract.State,
    closeDetailScreen: () -> Unit,
    onNewsSelected: ((NewsModel, ContentType) -> Unit)? = null,
) {
    composable(Destinations.NewsListScreen.route) { entry ->
        when (contentType) {
            ContentType.SINGLE_PANE -> SingleListScreen(
                uiState = uiState,
                onNewsSelected = onNewsSelected,
                contentType = contentType,
                closeDetailScreen = closeDetailScreen,
            )

            ContentType.DUAL_PANE -> {
                val newsItem =
                    entry.parcelableData<NewsModel>(Destinations.MarketDetailScreen().newsItem)
                        ?: uiState.newsItem
                ListWithDetailScreen(
                    displayFeatures = displayFeature,
                    newsItem = newsItem,
                    uiState = uiState,
                    onMarketSelected = onNewsSelected,
                    closeDetailScreen = closeDetailScreen,
                    contentType = contentType,
                )
            }
        }
    }
}

@Composable
fun SingleListScreen(
    uiState: MainContract.State,
    closeDetailScreen: () -> Unit,
    contentType: ContentType,
    onNewsSelected: ((NewsModel, ContentType) -> Unit)? = null,
) {
    if (uiState.newsItem != null && uiState.isDetailOnlyOpen) {
        BackHandler {
            closeDetailScreen()
        }
        MarketDetailRoute(
            newsItem = uiState.newsItem,
        )
    } else {
        MarketListRoute(
            onNavigateToDetailScreen = { mewsItem ->
                onNewsSelected?.invoke(mewsItem, contentType)
            },
            isDetailOnlyOpen = uiState.isDetailOnlyOpen,
            newsItem = uiState.newsItem,
            closeDetailScreen = closeDetailScreen,
            contentType = contentType,
        )
    }
}

@Composable
fun ListWithDetailScreen(
    displayFeatures: PersistentList<DisplayFeature>,
    newsItem: NewsModel?,
    uiState: MainContract.State,
    contentType: ContentType,
    closeDetailScreen: () -> Unit,
    onMarketSelected: ((NewsModel, ContentType) -> Unit)? = null,
) {
    TwoPane(
        first = {
            MarketListRoute(
                onNavigateToDetailScreen = { market ->
                    onMarketSelected?.invoke(market, contentType)
                },
                isDetailOnlyOpen = uiState.isDetailOnlyOpen,
                newsItem = uiState.newsItem,
                closeDetailScreen = closeDetailScreen,
                contentType = contentType,
            )
        },
        second = {
            MarketDetailRoute(
                newsItem = newsItem,
            )
        },
        strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f, gapWidth = 16.dp),
        displayFeatures = displayFeatures,
    )
}
