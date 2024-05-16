package com.mohammedalaa.data.di

import com.mohammedalaa.data.NewsRepositoryImpl
import com.mohammedalaa.data.api.NewsApi
import com.mohammedalaa.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun provideNewsRepository(newsRepository: NewsRepositoryImpl): NewsRepository
}
