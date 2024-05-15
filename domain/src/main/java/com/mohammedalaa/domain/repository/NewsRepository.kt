package com.mohammedalaa.domain.repository

import com.mohammedalaa.domain.model.Resource
import com.mohammedalaa.domain.model.ResultModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(apiKey:String): Flow<Resource<List<ResultModel>>>
}
