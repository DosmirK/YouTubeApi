package com.example.youtubeapi.data.repository

import androidx.lifecycle.LiveData
import com.example.youtubeapi.data.api.YouTubeApiService
import com.example.youtubeapi.data.base.BaseRepository
import com.example.youtubeapi.data.model.PlaylistsModel
import com.example.youtubeapi.utils.Resource

class PlaylistsRepository(
    private val api: YouTubeApiService
): BaseRepository() {

   suspend fun fetchPlaylists(): LiveData<Resource<PlaylistsModel>> =  doRequest { api.fetchPlaylists() }
}