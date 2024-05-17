package com.mohammedalaa.newslist

import androidx.lifecycle.viewModelScope
import com.mohammedalaa.core.base.BaseContract
import com.mohammedalaa.core.base.BaseViewModel
import com.mohammedalaa.core.dispatcher.DispatcherProvider
import com.mohammedalaa.domain.usecase.GetNewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsListUseCase: GetNewsListUseCase,
    dispatcherProvider: DispatcherProvider,
) : BaseViewModel(dispatcherProvider), NewsListContract {

    private val mutableState = MutableStateFlow(NewsListContract.State())
    override val state: StateFlow<NewsListContract.State> = mutableState.asStateFlow()
    override fun event(event: NewsListContract.Event) {
    }

    init {
        getData()
    }


    private fun getData() {
        viewModelScope.launch {
                getNewsList()
        }
    }

    private fun getNewsList() {
        mutableBaseState.update { BaseContract.BaseState.OnLoading }
        getNewsListUseCase.invoke("5Hys27XWhvaklRAY9UhR91vUHVUJkZK1")
            .onEach { result ->
                mutableState.update { prevState ->
                    prevState.copy(
                        newsList = result.data?.map { it }?.toPersistentList()!!,
                    )
                }
                mutableBaseState.update { BaseContract.BaseState.OnSuccess }
            }
            .catch { exception ->
                mutableBaseState.update {
                    BaseContract.BaseState.OnError(
                        errorMessage = exception.localizedMessage
                            ?: "An unexpected error occurred.",
                    )
                }
            }
            .launchIn(viewModelScope)
    }


}
