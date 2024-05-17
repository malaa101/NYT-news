
package com.mohammedalaa.newsdetails

import com.mohammedalaa.core.base.BaseViewModel
import com.mohammedalaa.core.dispatcher.DispatcherProvider
import com.mohammedalaa.domain.model.NewsModel
import com.mohammedalaa.domain.usecase.GetNewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsListUseCase,
    dispatcherProvider: DispatcherProvider,
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

  /*
  private fun getMarketChart(id: String, isRefreshing: Boolean = false) {
        mutableBaseState.update { BaseContract.BaseState.OnLoading }
        getNewsUseCase.invoke("dfjdfjf").onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let { newsItem ->
                        if (!isRefreshing) {
                            mutableBaseState.update {
                                BaseContract.BaseState.OnSuccess
                            }
                        } else {
                            mutableState.update {
                                NewsDetailContract.State(
                                    refreshing = false,
                                )
                            }
                        }
                        mutableState.update {
                            it.copy(newsItem = newsItem, loading = false)
                        }
                    }
                }

                is Resource.Error -> {
                    mutableBaseState.update {
                        BaseContract.BaseState.OnError(
                            errorMessage = result.exception?.localizedMessage
                                ?: "An unexpected error occurred.",
                        )
                    }
                }
            }
        }.catch { exception ->
            mutableBaseState.update {
                BaseContract.BaseState.OnError(
                    errorMessage = exception.localizedMessage ?: "An unexpected error occurred.",
                )
            }
        }.launchIn(viewModelScope)
    }
    */


}
