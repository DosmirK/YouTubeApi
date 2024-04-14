package com.example.youtubeapi.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.youtubeapi.data.paging.YouTubePlaylistsSource
import com.example.youtubeapi.data.utils.Constants

class PlaylistsViewModel(
    private val youTubePagingSource: YouTubePlaylistsSource
): ViewModel() {

    private val itemsFlow = Pager(
        config = PagingConfig(pageSize = Constants.MAX_RESULTS),
        pagingSourceFactory = { youTubePagingSource }
    ).flow.cachedIn(viewModelScope)

    fun getPlaylists() = itemsFlow

}