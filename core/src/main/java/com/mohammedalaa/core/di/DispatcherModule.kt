package com.mohammedalaa.core.di

import com.mohammedalaa.core.dispatcher.DispatcherProvider
import com.mohammedalaa.core.dispatcher.PlatformDispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DispatcherModule {
    @Binds
    fun bindDispatcherProvider(impl:PlatformDispatcherProvider): DispatcherProvider
}
