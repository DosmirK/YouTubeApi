package com.example.youtubeapi.ui.fragments.video_piayer

import androidx.navigation.fragment.navArgs
import com.example.youtubeapi.databinding.FragmentVideoBinding
import com.example.youtubeapi.ui.base.BaseFragment
import com.example.youtubeapi.ui.viewmodels.VideoViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class VideoFragment :
    BaseFragment<FragmentVideoBinding, VideoViewModel>(FragmentVideoBinding::inflate) {

    override val viewModel: VideoViewModel by viewModel()
    private val args: VideoFragmentArgs by navArgs()
    override fun init() {
        super.init()
        val youTubePlayerView: YouTubePlayerView = binding.youtubePlayerView
        lifecycle.addObserver(youTubePlayerView)
        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(args.videoId, 0f)
            }
        })

        binding.tvVideoTitle.text = args.videoTitle
        binding.tvVideoDesc.text = args.videoDesc
    }
}