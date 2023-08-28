package com.feature.movie_details.domain.di

import com.feature.movie_details.domain.repo.MovieDetailsRepository
import com.feature.movie_details.domain.use_case.GetMovieDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MovieDetailsDomainModule {

    @Provides
    fun provideMovieDetailsUseCase(
        movieDetailsRepository: MovieDetailsRepository
    ): GetMovieDetailsUseCase {
        return GetMovieDetailsUseCase(movieDetailsRepository)
    }
}