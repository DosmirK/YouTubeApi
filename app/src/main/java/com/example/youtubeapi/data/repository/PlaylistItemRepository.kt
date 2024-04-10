package com.example.youtubeapi.data.repository

import com.example.youtubeapi.data.api.YouTubeApiService
import com.example.youtubeapi.data.base.BaseRepository

class PlaylistItemRepository(
    private val api: YouTubeApiService
): BaseRepository() {

}