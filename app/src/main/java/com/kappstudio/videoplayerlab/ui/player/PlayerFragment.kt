package com.kappstudio.videoplayerlab.ui.player

import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.PlayerView
import com.kappstudio.videoplayerlab.factory.VMFactory
import com.kappstudio.videoplayerlab.VideoApp.Companion.application
import com.kappstudio.videoplayerlab.databinding.FragmentPlayerBinding
import com.kappstudio.videoplayerlab.util.isInternetConnected
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

    private fun setSubtitle() {
        if (viewModel.product.value?.isSeries != false) {
            playerView.findViewById<TextView>(R.id.exo_subtitle).text =
                viewModel.product.value!!.videoList[viewModel.currentEpisode.value!!].title
        }
    }

    private fun initPlayer() {

        // Create a player instance and setup 10sec skip-interval for forward and rewind buttons.
        mPlayer = ExoPlayer.Builder(application)
            .setSeekForwardIncrementMs(10000)
            .setSeekBackIncrementMs(10000)
            .build()

        // Bind the player to the view.
        playerView.player = mPlayer

        mPlayer?.apply {
            // Set the media source to be played.
            this.addMediaSources(viewModel.buildMediaSource())
            this.seekTo(
                viewModel.currentEpisode.value ?: 0,
                viewModel.playbackPosition.value ?: 0L
            )
            //Setting exoplayer when it is ready.
            this.playWhenReady = true

            this.addListener(playbackStateListener())

            // Prepare the player.
            this.prepare()
        }

        //Custom control view
        playerView.findViewById<TextView>(R.id.title).text = viewModel.product.value?.name

        activity?.findViewById<ImageButton>(appR.id.btn_close)?.setOnClickListener {
            findNavController().popBackStack()
        }

        if (viewModel.product.value?.isSeries == false) {
            activity?.findViewById<LinearLayout>(appR.id.layout_prev_next)?.visibility =
                View.INVISIBLE
        }
        setSubtitle()
    }

    //Release the player
    private fun releasePlayer() {
        mPlayer?.apply {
            //Sava play back info before release.
            viewModel.setPlaybackPosition(this.currentPosition)
            viewModel.setCurrentEpisode(this.currentMediaItemIndex)

            this.release()
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
        releasePlayer()
    }

    private fun playbackStateListener() = object : Player.Listener {

        //Set subtitle when media change.
        override fun onPositionDiscontinuity(
            oldPosition: Player.PositionInfo,
            newPosition: Player.PositionInfo,
            reason: Int
        ) {
            super.onPositionDiscontinuity(oldPosition, newPosition, reason)
            viewModel.setCurrentEpisode(mPlayer?.currentMediaItemIndex ?: 0)
            setSubtitle()
        }

        //Show  progressBar when loading
        override fun onPlaybackStateChanged(playbackState: Int) {
            binding.progressBar.visibility = when (playbackState) {
                Player.STATE_BUFFERING -> View.VISIBLE
                else -> View.GONE
            }
        }

        //Error when playing.
        override fun onPlayerError(error: PlaybackException) {
            super.onPlayerError(error)

            //Internet connected error.
            if (!isInternetConnected()) {
                Toast.makeText(
                    application,
                    application.getString( appR.string.network_error),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(application, error.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}