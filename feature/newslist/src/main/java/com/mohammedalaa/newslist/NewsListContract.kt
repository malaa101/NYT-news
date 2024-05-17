package com.mohammedalaa.newslist

import com.mohammedalaa.core.UnidirectionalViewModel
import com.mohammedalaa.domain.model.NewsModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf


interface NewsListContract :
    UnidirectionalViewModel<NewsListContract.Event, NewsListContract.State> {

    data class State(val newsList: PersistentList<NewsModel> = persistentListOf())

    sealed class Event
}
