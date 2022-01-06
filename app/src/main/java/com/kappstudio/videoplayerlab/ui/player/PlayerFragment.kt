package com.kappstudio.videoplayerlab.ui.player

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.PlayerView
import com.kappstudio.videoplayerlab.VMFactory
import com.kappstudio.videoplayerlab.VideoApp.Companion.application
import com.kappstudio.videoplayerlab.databinding.FragmentPlayerBinding

class PlayerFragment : Fragment() {

    private val viewModel: PlayerViewModel by viewModels {
        VMFactory {
            PlayerViewModel(
                PlayerFragmentArgs.fromBundle(requireArguments()).product
            )
        }
    }
    private var mPlayer: ExoPlayer? = null
    private lateinit var playerView: PlayerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
        val binding = FragmentPlayerBinding.inflate(inflater, container, false)

        playerView = binding.playerView

        //Into full screen
        binding.playerView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        viewModel.product.observe(viewLifecycleOwner) {
            // Set the media source to be played.
            mPlayer?.addMediaSources(viewModel.buildMediaSource(it.videoList))
        }

        return binding.root
    }

    private fun initPlayer() {

        // Create a player instance.
        mPlayer = ExoPlayer.Builder(application).build()

        // Bind the player to the view.
        playerView.player = mPlayer

        //Setting exoplayer when it is ready.
        mPlayer?.playWhenReady = true

        // Prepare the player.
        mPlayer?.prepare()
    }

    override fun onStart() {
        super.onStart()
        initPlayer()
    }

    private fun releasePlayer() {
        if (mPlayer == null) {
            return
        }
        //release player
        mPlayer?.release()
        mPlayer = null
    }

    override fun onDestroy() {
        super.onDestroy()
        releasePlayer()
    }
}