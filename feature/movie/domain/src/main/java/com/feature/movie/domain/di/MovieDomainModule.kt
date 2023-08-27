package com.feature.movie.domain.di

import com.feature.movie.domain.repo.MovieRepository
import com.feature.movie.domain.use_case.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object MovieDomainModule {

    @Provides
    fun provideMovieListUseCase(
        movieRepository: MovieRepository
    ): GetMovieListUseCase = GetMovieListUseCase(movieRepository)
}