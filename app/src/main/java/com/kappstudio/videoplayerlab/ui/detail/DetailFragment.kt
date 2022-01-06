package com.kappstudio.videoplayerlab.ui.detail

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kappstudio.videoplayerlab.VMFactory
import com.kappstudio.videoplayerlab.databinding.FragmentDetailBinding
import com.kappstudio.videoplayerlab.ui.home.HomeFragmentDirections
import com.kappstudio.videoplayerlab.util.setImage

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels {
        VMFactory {
            DetailViewModel(
                DetailFragmentArgs.fromBundle(requireArguments()).product
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val binding = FragmentDetailBinding.inflate(inflater, container, false)

        val adapter = VideoAdapter(viewModel)
        binding.rvVideo.adapter = adapter

        binding.btnBack.setOnClickListener { findNavController().popBackStack() }
        binding.btnPlay.setOnClickListener { viewModel.navToPlayer(0) }

        viewModel.product.observe(viewLifecycleOwner) {
            binding.apply {
                tvTitle.text = it.name
                setImage(ivCover, it.cover)
                tvProductName.text = it.name
                tvDesc.text = it.desc

                if (it.isSeries) {
                    adapter.submitList(it.videoList)
                } else {
                    layoutSeries.visibility = View.GONE
                }
            }
        }

        viewModel.navToPlayer.observe(viewLifecycleOwner) {
            it?.let {
                viewModel.product.value?.let { product ->
                    findNavController().navigate(
                        DetailFragmentDirections.navToPlayerFragment(
                            product,
                            it
                        )
                    )
                }
                viewModel.onNavToPlayer()
            }
        }

        return binding.root
    }
}