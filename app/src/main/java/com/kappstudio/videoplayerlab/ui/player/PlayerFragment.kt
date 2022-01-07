package com.kappstudio.videoplayerlab.ui.player

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.PlayerView
import com.kappstudio.videoplayerlab.factory.VMFactory
import com.kappstudio.videoplayerlab.VideoApp.Companion.application
import com.kappstudio.videoplayerlab.databinding.FragmentPlayerBinding
import com.kappstudio.videoplayerlab.R as appR

class PlayerFragment : Fragment() {

    private lateinit var binding: FragmentPlayerBinding

    private val viewModel: PlayerViewModel by viewModels {
        VMFactory {
            PlayerViewModel(
                PlayerFragmentArgs.fromBundle(requireArguments()).product,
                PlayerFragmentArgs.fromBundle(requireArguments()).episode
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
        binding = FragmentPlayerBinding.inflate(inflater, container, false)

        playerView = binding.playerView

        //Into full screen
        binding.playerView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        return binding.root
    }

    private fun setSubTitle(subTitle: String) {
        playerView.findViewById<TextView>(R.id.exo_subtitle).text = subTitle
    }

    private fun initPlayer() {

        // Create a player instance and setup 10sec skip-interval for forward and rewind buttons.
        mPlayer = ExoPlayer.Builder(application)
            .setSeekForwardIncrementMs(10000)
            .setSeekBackIncrementMs(10000)
            .build()

        // Bind the player to the view.
        playerView.player = mPlayer

        // Set the media source to be played.
        mPlayer?.addMediaSources(viewModel.buildMediaSource())

        //Setting exoplayer when it is ready.
        mPlayer?.playWhenReady = true

        mPlayer?.addListener(playbackStateListener())

        // Prepare the player.
        mPlayer?.prepare()

        //Custom control view
        playerView.findViewById<TextView>(R.id.title).text = viewModel.product.value?.name
        activity?.findViewById<ImageButton>(appR.id.btn_close)?.setOnClickListener {
            findNavController().popBackStack()
        }
        if (viewModel.product.value?.isSeries == false) {
            activity?.findViewById<LinearLayout>(appR.id.layout_prev_next)?.visibility =
                View.INVISIBLE
            //  setSubTitle(viewModel.product
        }

    }

    override fun onStart() {
        super.onStart()
        initPlayer()
    }

    override fun onPause() {
        super.onPause()
        mPlayer?.pause()
    }

    override fun onStop() {
        super.onStop()
        mPlayer?.release()
    }

    //Show  progressBar when loading
    private fun playbackStateListener() = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            binding.progressBar.visibility = when (playbackState) {
                Player.STATE_BUFFERING -> View.VISIBLE
                 else -> View.GONE
            }
        }
    }
}