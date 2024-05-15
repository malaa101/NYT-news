package com.mohammedalaa.data.di

import com.mohammedalaa.data.NewsRepositoryImpl
import com.mohammedalaa.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindMarketRepository(
        marketsRepository: NewsRepositoryImpl,
    ): NewsRepository
}
