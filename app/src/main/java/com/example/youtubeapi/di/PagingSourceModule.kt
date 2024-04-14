package com.example.youtubeapi.di

import com.example.youtubeapi.data.api.YouTubeApiService
import com.example.youtubeapi.data.paging.YouTubePlaylistsSource
import org.koin.dsl.module

val pagingSourceModule = module {
    factory { provideYouTubePagingSource(get()) }
}

fun provideYouTubePagingSource(apiService: YouTubeApiService) =
    YouTubePlaylistsSource(apiService)