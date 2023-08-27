package com.feature.movie.data.di

import com.feature.movie.data.remote.MovieDataSource
import com.feature.movie.data.repo.MovieRepositoryImpl
import com.feature.movie.domain.repo.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDataModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(retrofit: Retrofit): MovieDataSource {
        return retrofit.create(MovieDataSource::class.java)
    }

    @Provides
    @Singleton
    @Named("api_key")
    fun provideApiKey(): String {
        return ""
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieDataSource: MovieDataSource,
        @Named("api_key") apiKey: String
    ): MovieRepository {
        return MovieRepositoryImpl(movieDataSource, apiKey)
    }
}