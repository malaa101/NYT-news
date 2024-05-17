package com.mohammedalaa.nyt_news.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.window.layout.DisplayFeature
import com.mohammedalaa.designsystem.util.ContentType
import com.mohammedalaa.domain.model.NewsModel
import com.mohammedalaa.navigation.Destinations
import com.mohammedalaa.navigation.MainContract
import com.mohammedalaa.navigation.graph.newsDetail
import com.mohammedalaa.navigation.graph.newsList
import kotlinx.collections.immutable.PersistentList

@Composable
fun NewsNavHost(
    navController: NavHostController,
    modifier: Modifier,
    contentType: ContentType,
    displayFeatures: PersistentList<DisplayFeature>,
    onNewsSelected: ((NewsModel, ContentType) -> Unit)? = null,
    closeDetailScreen: () -> Unit,
    uiState: MainContract.State
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.NewsListScreen.route,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        newsList(
            displayFeature = displayFeatures,
            contentType = contentType,
            onNewsSelected = onNewsSelected,
            closeDetailScreen = closeDetailScreen,
            uiState = uiState
        )

        newsDetail(
            uiState = uiState,
        )
    }
}