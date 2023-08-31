package com.core.network.di

import com.core.network.movie.datasource.MovieDataSource
import com.core.network.movie.datasource.MovieDataSourceRetrofit
import com.core.network.retrofit.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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

    @Provides
    @Singleton
    fun provideMovieApiService(
        retrofit: Retrofit
    ): MovieApiService {
        return retrofit.create(MovieApiService::class.java)
    }
}