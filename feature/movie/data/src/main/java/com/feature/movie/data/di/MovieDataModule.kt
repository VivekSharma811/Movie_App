package com.feature.movie.data.di

import com.core.network.movie.datasource.MovieDataSource
import com.feature.movie.data.repo.MovieRepositoryImpl
import com.feature.movie.domain.repo.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDataModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieDataSource: MovieDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieDataSource)
    }
}