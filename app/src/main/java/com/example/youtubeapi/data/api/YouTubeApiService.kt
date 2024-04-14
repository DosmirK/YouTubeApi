package com.example.youtubeapi.data.api

import com.example.youtubeapi.data.model.PlaylistsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {

    @GET("playlists")
    suspend fun fetchPlaylists(
        @Query("pageToken") pageToken: String
    ): Response<PlaylistsModel>

    @GET("playlistItems/")
    suspend fun fetchVideos(
        @Query("playlistId") playlistId: String,
        @Query("pageToken") pageToken: String
    ) : Response<PlaylistsModel>
}