package com.example.youtubeapi.di

import com.example.youtubeapi.data.api.YouTubeApiService
import com.example.youtubeapi.data.paging.YouTubePlaylistsSource
import com.example.youtubeapi.data.repository.VideoRepository
import com.example.youtubeapi.ui.viewmodels.PlaylistItemViewModel
import com.example.youtubeapi.ui.viewmodels.PlaylistsViewModel
import com.example.youtubeapi.ui.viewmodels.VideoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<PlaylistsViewModel> { providePlaylistsViewModel(get()) }
    viewModel<PlaylistItemViewModel> { providePlaylistItemViewModel(get()) }
    viewModel<VideoViewModel> { provideVideoViewModel(get()) }
}

fun providePlaylistsViewModel(youTubePagingSource: YouTubePlaylistsSource) =
    PlaylistsViewModel(youTubePagingSource)

fun providePlaylistItemViewModel(apiService: YouTubeApiService) =
    PlaylistItemViewModel(apiService)

fun provideVideoViewModel(repository: VideoRepository) =
    VideoViewModel(repository)