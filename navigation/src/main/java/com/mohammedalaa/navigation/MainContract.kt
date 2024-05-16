package com.mohammedalaa.navigation

import com.mohammedalaa.core.UnidirectionalViewModel
import com.mohammedalaa.designsystem.util.ContentType
import com.mohammedalaa.domain.model.NewsModel

interface MainContract : UnidirectionalViewModel<MainContract.Event, MainContract.State> {

    data class State(val newsItem: NewsModel? = null, val isDetailOnlyOpen: Boolean = false)

    sealed class Event {
        data class SetNewsItem(val newsModel: NewsModel?, val contentType: ContentType) : Event()
    }
}
