package com.mohammedalaa.data

import com.mohammedalaa.domain.repository.NewsRepository
import com.mohammedalaa.data.api.NewsApi
import com.mohammedalaa.data.mapper.toDomain
import com.mohammedalaa.domain.model.Resource
import com.mohammedalaa.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi,
) : NewsRepository {

    override  fun getNews(apiKey: String): Flow<Resource<List<NewsModel>>> =
        flow {
            try {
                val news = api.getNews(apiKey).toDomain()
                emit(Resource.Success(news.results))
            } catch (e: Exception) {
                emit(Resource.Error(exception = e))
            }

    }


}
