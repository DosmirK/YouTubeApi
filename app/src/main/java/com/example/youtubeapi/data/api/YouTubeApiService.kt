package com.example.youtubeapi.data.api

import com.example.youtubeapi.data.model.PlaylistsModel
import retrofit2.Response
import retrofit2.http.GET

interface YouTubeApiService {

    @GET("playlists")
    suspend fun fetchPlaylists(): Response<PlaylistsModel>
}