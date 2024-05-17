package com.mohammedalaa.nyt_news.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.DisplayFeature
import androidx.window.layout.FoldingFeature
import com.mohammedalaa.domain.model.NewsModel
import com.mohammedalaa.designsystem.util.ContentType
import com.mohammedalaa.designsystem.util.DevicePosture
import com.mohammedalaa.designsystem.util.isBookPosture
import com.mohammedalaa.designsystem.util.isSeparating
import com.mohammedalaa.navigation.MainContract
import com.mohammedalaa.nyt_news.navigation.NewsNavHost
import kotlinx.collections.immutable.PersistentList

@Composable
fun NewsApp(
    windowSize: WindowSizeClass,
    displayFeatures: PersistentList<DisplayFeature>,
    onNewsItemSelected: ((NewsModel, ContentType) -> Unit)? = null,
    closeDetailScreen: () -> Unit,
    uiState: MainContract.State
) {


    val contentType: ContentType

    val foldingFeature = displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()
    val foldingDevicePosture = when {
        isBookPosture(foldingFeature) ->
            DevicePosture.BookPosture(foldingFeature.bounds)

        isSeparating(foldingFeature) ->
            DevicePosture.Separating(foldingFeature.bounds, foldingFeature.orientation)

        else -> DevicePosture.NormalPosture
    }

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            contentType = ContentType.SINGLE_PANE
        }

        WindowWidthSizeClass.Medium -> {
            contentType = if (foldingDevicePosture != DevicePosture.NormalPosture) {
                ContentType.DUAL_PANE
            } else {
                ContentType.SINGLE_PANE
            }
        }

        WindowWidthSizeClass.Expanded -> {
            contentType = ContentType.DUAL_PANE
        }

        else -> {
            contentType = ContentType.SINGLE_PANE
        }
    }

    NewsAppWrapper(
        contentType = contentType,
        displayFeatures = displayFeatures,
        onNewsSelected = onNewsItemSelected,
        closeDetailScreen = closeDetailScreen,
        uiState = uiState
    )

}

@Composable
fun NewsAppWrapper(
    contentType: ContentType,
    displayFeatures: PersistentList<DisplayFeature>,
    onNewsSelected: ((NewsModel, ContentType) -> Unit)? = null,
    closeDetailScreen: () -> Unit,
    uiState: MainContract.State
) {

    val navController = rememberNavController()
    Scaffold { paddingValues ->
        Row(
            modifier = Modifier.padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                NewsNavHost(
                    modifier = Modifier
                        .weight(1f),
                    navController = navController,
                    contentType = contentType,
                    displayFeatures = displayFeatures,
                    onNewsSelected = onNewsSelected,
                    closeDetailScreen = closeDetailScreen,
                    uiState = uiState
                )
            }

        }
    }
}