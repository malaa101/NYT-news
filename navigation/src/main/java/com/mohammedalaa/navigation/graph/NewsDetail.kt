package com.mohammedalaa.navigation.graph
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohammedalaa.domain.model.NewsModel
import com.mohammedalaa.navigation.Destinations
import com.mohammedalaa.navigation.MainContract
import com.mohammedalaa.navigation.ext.parcelableData
import com.mohammedalaa.newsdetails.MarketDetailRoute

fun NavGraphBuilder.newsDetail(
    uiState: MainContract.State,
) {
    composable(
        route = Destinations.MarketDetailScreen().route,
        enterTransition = {
            slideIntoContainer(
                animationSpec = tween(300, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
            )
        },
        exitTransition = {
            slideOutOfContainer(
                animationSpec = tween(300, easing = EaseOut),
                towards = AnimatedContentTransitionScope.SlideDirection.End,
            )
        },
    ) { entry ->
        val newsItem = entry.parcelableData<NewsModel>(Destinations.MarketDetailScreen().newsItem)
            ?: uiState.newsItem as NewsModel
        MarketDetailRoute(
            newsItem = newsItem,
        )
    }
}
