package com.mohammedalaa.newslist

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import com.mohammedalaa.core.base.BaseRoute
import com.mohammedalaa.core.use
import com.mohammedalaa.designsystem.preview.ThemePreviews
import com.mohammedalaa.designsystem.theme.NYTnewsTheme
import com.mohammedalaa.designsystem.util.ContentType
import com.mohammedalaa.designsystem.widget.ShimmerNewsList
import com.mohammedalaa.domain.model.NewsModel
import com.mohammedalaa.newslist.component.NewsListItem
import com.mohammedalaa.newslist.preview_provider.NewsListStateProvider


@Composable
fun NewsListRoute(
    viewModel: NewsListViewModel = hiltViewModel(),
    isDetailOnlyOpen: Boolean,
    newsItem: NewsModel?,
    closeDetailScreen: () -> Unit,
    onNavigateToDetailScreen: (newsItem: NewsModel) -> Unit,
    contentType: ContentType,
) {
    val (state) = use(viewModel = viewModel)

    LaunchedEffect(key1 = contentType) {
        if (contentType == ContentType.SINGLE_PANE && !isDetailOnlyOpen) {
            closeDetailScreen()
        }
    }

    if (contentType == ContentType.DUAL_PANE && state.newsList.isNotEmpty() && newsItem == null) {
        onNavigateToDetailScreen(state.newsList[0])
    }

    BaseRoute(baseViewModel = viewModel, shimmerView = {
        ShimmerNewsList()
    }) {
        NewsListScreen(
            newsListState = state, onNavigateToDetailScreen = onNavigateToDetailScreen
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun NewsListScreen(
    newsListState: NewsListContract.State, onNavigateToDetailScreen: (newsItem: NewsModel) -> Unit
) {

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(
                items = newsListState.newsList
            ) { newsItem ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItemPlacement(
                            animationSpec = tween(durationMillis = 250),
                        ),
                ) {
                    NewsListItem(
                        modifier = Modifier,
                        newsItem = newsItem,
                        onItemClick = {
                            onNavigateToDetailScreen(newsItem)
                        },
                    )
                }
            }
        }
    }
}

@ThemePreviews
@Composable
private fun NewsListScreenPrev(
    @PreviewParameter(NewsListStateProvider::class) newsListState: NewsListContract.State,
) {
    NYTnewsTheme {
        Surface {
            NewsListScreen(
                newsListState = newsListState,
                onNavigateToDetailScreen = {},
            )
        }
    }
}
