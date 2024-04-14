package com.example.youtubeapi.ui.fragments.playlists

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.youtubeapi.databinding.FragmentPlaylistsBinding
import com.example.youtubeapi.ui.adapters.PlaylistsVideosAdapter
import com.example.youtubeapi.ui.base.BaseFragment
import com.example.youtubeapi.ui.viewmodels.PlaylistsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistsFragment : BaseFragment<
        FragmentPlaylistsBinding, PlaylistsViewModel
        >(FragmentPlaylistsBinding::inflate) {

    override val viewModel: PlaylistsViewModel by viewModel()
    private val adapter: PlaylistsVideosAdapter by inject()

    override fun init() {
        super.init()
        binding.rvPlaylists.adapter = adapter
        adapter.setOnItemClickListener {
            findNavController().navigate(
                PlaylistsFragmentDirections.actionPlaylistsFragmentToPlaylistItemFragment(
                    playlistId = it.id,
                    playlistTitle = it.snippet.title,
                    playlistDesc = it.snippet.localized.description ?: ""
                )
            )
        }
    }

    override fun observe() {
        super.observe()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPlaylists().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}