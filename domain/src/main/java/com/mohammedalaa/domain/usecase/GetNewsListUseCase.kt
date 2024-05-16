package com.mohammedalaa.domain.usecase

import com.mohammedalaa.domain.model.Resource
import com.mohammedalaa.domain.model.NewsModel
import com.mohammedalaa.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsListUseCase @Inject constructor(
    private val repository: NewsRepository,
) {
     operator fun invoke(apiKey: String): Flow<Resource<List<NewsModel>>> {
        return repository.getNews(apiKey)
    }
}
