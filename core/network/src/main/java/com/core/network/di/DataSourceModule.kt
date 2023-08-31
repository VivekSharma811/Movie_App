package com.core.network.di

import com.core.network.datasource.MovieDataSource
import com.core.network.retrofit.datasource.MovieDataSourceRetrofit
import com.core.network.retrofit.api_service.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(
        movieApiService: MovieApiService,
        @Named("api_key") apiKey: String
    ): MovieDataSource {
        return MovieDataSourceRetrofit(movieApiService, apiKey)
    }
}