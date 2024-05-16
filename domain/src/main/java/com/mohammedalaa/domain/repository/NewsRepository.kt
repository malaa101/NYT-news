package com.mohammedalaa.domain.repository

import com.mohammedalaa.domain.model.Resource
import com.mohammedalaa.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(apiKey:String): Flow<Resource<List<NewsModel>>>
}
