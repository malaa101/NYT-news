
package com.mohammedalaa.newsdetails

import com.mohammedalaa.core.base.BaseViewModel
import com.mohammedalaa.core.dispatcher.DispatcherProvider
import com.mohammedalaa.domain.model.NewsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(dispatcherProvider: DispatcherProvider,
) : BaseViewModel(dispatcherProvider), NewsDetailContract {

    private val mutableState = MutableStateFlow(NewsDetailContract.State())
    override val state: StateFlow<NewsDetailContract.State> = mutableState.asStateFlow()

    override fun event(event: NewsDetailContract.Event) = when (event) {
        is NewsDetailContract.Event.SetNewsItem -> setNewsItem(newsItem = event.newsItem)
    }

    private fun setNewsItem(newsItem: NewsModel?) {
        mutableState.update {
            it.copy(newsItem = newsItem)
        }
    }
}
