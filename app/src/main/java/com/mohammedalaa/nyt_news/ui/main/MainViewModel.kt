package com.mohammedalaa.nyt_news.ui.main

import androidx.lifecycle.viewModelScope
import com.mohammedalaa.domain.model.NewsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.mohammedalaa.core.base.BaseViewModel
import com.mohammedalaa.designsystem.util.ContentType
import com.mohammedalaa.navigation.MainContract
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    dispatcherProvider: com.mohammedalaa.core.dispatcher.DispatcherProvider,
) : BaseViewModel(dispatcherProvider), MainContract {

    private val mutableState = MutableStateFlow(MainContract.State())
    override val state: StateFlow<MainContract.State> = mutableState.asStateFlow()
    override fun event(event: MainContract.Event) {
        when (event) {
            is MainContract.Event.SetNewsItem -> setNews(event.newsModel, event.contentType)
        }
    }

    private fun setNews(news: NewsModel?, contentType: ContentType) = viewModelScope.launch {
        mutableState.emit(
            mutableState.value.copy(
                newsItem = news,
                isDetailOnlyOpen = contentType == ContentType.SINGLE_PANE
            )
        )
    }

    fun closeDetailScreen() = viewModelScope.launch {
        mutableState.emit(
            mutableState.value.copy(
                isDetailOnlyOpen = false
            )
        )
    }
}