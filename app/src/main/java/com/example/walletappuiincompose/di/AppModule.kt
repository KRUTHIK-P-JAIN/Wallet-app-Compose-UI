package com.example.walletappuiincompose.di

import com.example.walletappuiincompose.data.api.Api
import com.example.walletappuiincompose.data.api.RetrofitInstance
import com.example.walletappuiincompose.data.repository.RepositoryImpl
import com.example.walletappuiincompose.usecase.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): Api = RetrofitInstance.api

    @Provides
    @Singleton
    fun provideRepository(api: Api): Repository = RepositoryImpl(api)
}