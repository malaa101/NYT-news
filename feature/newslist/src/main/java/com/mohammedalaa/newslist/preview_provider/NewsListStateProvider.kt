package com.mohammedalaa.newslist.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.mohammedalaa.domain.modelprovider.newsList
import com.mohammedalaa.newslist.NewsListContract
import kotlinx.collections.immutable.toPersistentList

class NewsListStateProvider : PreviewParameterProvider<NewsListContract.State> {
    override val values: Sequence<NewsListContract.State> = sequenceOf(
        NewsListContract.State(
            newsList = newsList.map { it }.toPersistentList(),
        ),
    )
}
