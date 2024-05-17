package com.mohammedalaa.newsdetails

import com.mohammedalaa.core.UnidirectionalViewModel
import com.mohammedalaa.domain.model.NewsModel


interface NewsDetailContract : UnidirectionalViewModel<NewsDetailContract.Event, NewsDetailContract.State> {

    data class State(
        val newsItem: NewsModel? = null,
        val loading: Boolean = true,
        val refreshing: Boolean = false,
    )

    sealed class Event {
        data class SetNewsItem(val newsItem: NewsModel?) : Event()
    }
}
