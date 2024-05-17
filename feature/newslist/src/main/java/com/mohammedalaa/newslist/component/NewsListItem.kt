package com.mohammedalaa.newslist.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mohammedalaa.designsystem.widget.NewsItem
import com.mohammedalaa.domain.model.NewsModel

@Composable
fun NewsListItem(
    modifier: Modifier,
    newsItem: NewsModel,
    onItemClick: () -> Unit,
) {
    NewsItem(
        modifier = modifier,
        title = newsItem.title ?: "title",
        abstract = newsItem.abstract ?: "title abstract",
        urlToImage = newsItem.media?.getOrNull(0)?.mediaMetadata?.getOrNull(0)?.url ?: "url",
        publishedAt = newsItem.publishedDate ?: "published date",
        onItemClick = onItemClick,
    )
}
