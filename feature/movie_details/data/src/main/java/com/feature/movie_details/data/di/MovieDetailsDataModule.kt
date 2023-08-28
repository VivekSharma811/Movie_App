package com.feature.movie_details.data.di

import com.feature.movie_details.data.remote.MovieDetailsDataSource
import com.feature.movie_details.data.repo.MovieDetailsRepoImpl
import com.feature.movie_details.domain.repo.MovieDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailsDataModule {

    @Provides
    @Singleton
    fun provideMovieDetailsDataSource(retrofit: Retrofit): MovieDetailsDataSource {
        return retrofit.create(MovieDetailsDataSource::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieDetailsRepository(
        movieDetailsDataSource: MovieDetailsDataSource,
        @Named("api_key") apiKey: String
    ): MovieDetailsRepository {
        return MovieDetailsRepoImpl(movieDetailsDataSource, apiKey)
    }
}