package com.example.youtubeapi.ui.fragments.playlist_item

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.youtubeapi.databinding.FragmentPlaylistItemBinding
import com.example.youtubeapi.ui.adapters.PlaylistsVideosAdapter
import com.example.youtubeapi.ui.base.BaseFragment
import com.example.youtubeapi.ui.viewmodels.PlaylistItemViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistItemFragment : BaseFragment<
        FragmentPlaylistItemBinding, PlaylistItemViewModel
        >(FragmentPlaylistItemBinding::inflate) {

    override val viewModel: PlaylistItemViewModel by viewModel()
    private val args: PlaylistItemFragmentArgs by navArgs()
    private val adapter: PlaylistsVideosAdapter by inject()

    override fun init() = with(binding) {
        super.init()
        tvPlaylistTitle.text = args.playlistTitle
        tvPlaylistDesc.text = args.playlistDesc
        rvVideos.adapter = adapter
        viewModel.setupPlaylistId(args.playlistId)
        adapter.setOnItemClickListener { video ->
            findNavController().navigate(
                PlaylistItemFragmentDirections.actionPlaylistItemFragmentToVideoFragment(
                    videoDesc = video.snippet.description,
                    videoTitle = video.snippet.title,
                    videoId = video.contentDetails.videoId!!
                )
            )
        }
    }

    override fun observe() {
        super.observe()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getVideos()?.collectLatest {
                adapter.submitData(it)
            }
        }
    }

}