package com.example.youtubeapi.di

import com.example.youtubeapi.data.api.YouTubeApiService
import com.example.youtubeapi.data.repository.VideoRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { provideVideoRepository(get()) }
}

fun provideVideoRepository(apiService: YouTubeApiService) =
    VideoRepository(apiService)