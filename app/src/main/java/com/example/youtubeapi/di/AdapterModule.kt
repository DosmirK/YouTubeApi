package com.example.youtubeapi.di

import com.example.youtubeapi.ui.adapters.PlaylistsAdapter
import org.koin.dsl.module

val adapterModule = module {
    single { providePlaylistsAdapter() }
}

fun providePlaylistsAdapter() =
    PlaylistsAdapter()