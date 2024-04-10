package com.example.youtubeapi.di

import com.example.youtubeapi.data.api.YouTubeApiService
import com.example.youtubeapi.data.repository.PlaylistItemRepository
import com.example.youtubeapi.data.repository.PlaylistsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { providePlaylistsRepository(get()) }
    single { providePlaylistItemRepository(get()) }
}

fun providePlaylistsRepository(api: YouTubeApiService) =
    PlaylistsRepository(api)

fun providePlaylistItemRepository(api: YouTubeApiService) =
    PlaylistItemRepository(api)