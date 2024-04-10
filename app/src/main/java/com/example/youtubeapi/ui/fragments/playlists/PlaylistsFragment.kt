package com.example.youtubeapi.ui.fragments.playlists

import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import com.example.youtubeapi.databinding.FragmentPlaylistsBinding
import com.example.youtubeapi.ui.adapters.PlaylistsAdapter
import com.example.youtubeapi.ui.base.BaseFragment
import com.example.youtubeapi.ui.viewmodels.PlaylistsViewModel
import com.example.youtubeapi.utils.Resource
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistsFragment : BaseFragment<
        FragmentPlaylistsBinding, PlaylistsViewModel
        >(FragmentPlaylistsBinding::inflate) {

    override val viewModel: PlaylistsViewModel by viewModel()
    private val adapter: PlaylistsAdapter by inject()

    override fun init() {
        super.init()
        binding.rvPlaylists.adapter = adapter
    }

    override fun observe() {
        super.observe()
        viewModel.viewModelScope.launch {
            viewModel.getPlaylists().stataHandler(
                success = {
                    adapter.submitList(it.items)
                },
                state = {
                    binding.animLoading.isVisible = it is Resource.Loading
                }
            )
        }
    }

}