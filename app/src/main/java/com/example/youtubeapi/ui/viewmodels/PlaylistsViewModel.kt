package com.example.youtubeapi.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.youtubeapi.data.repository.PlaylistsRepository

class PlaylistsViewModel(
    private val repository: PlaylistsRepository
): ViewModel() {

    suspend fun getPlaylists() = repository.fetchPlaylists()
}