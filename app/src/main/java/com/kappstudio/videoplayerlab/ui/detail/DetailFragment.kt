package com.kappstudio.videoplayerlab.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kappstudio.videoplayerlab.VMFactory
import com.kappstudio.videoplayerlab.databinding.FragmentDetailBinding
import com.kappstudio.videoplayerlab.ui.home.ProductAdapter
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
        val binding = FragmentDetailBinding.inflate(inflater, container, false)

        val adapter = VideoAdapter(viewModel)
        binding.rvVideo.adapter = adapter


        binding.btnBack.setOnClickListener { findNavController().popBackStack() }

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

        return binding.root
    }
}