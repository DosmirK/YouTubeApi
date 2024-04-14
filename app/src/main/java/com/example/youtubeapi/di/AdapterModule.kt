package com.example.youtubeapi.di

import com.example.youtubeapi.ui.adapters.PlaylistsVideosAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { providePlaylistsAdapter() }
}

fun providePlaylistsAdapter() =
    PlaylistsVideosAdapter()