package com.kappstudio.videoplayerlab.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kappstudio.videoplayerlab.databinding.FragmentHomeBinding
import android.content.pm.ActivityInfo

import android.app.Activity




class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        val adapter = ProductAdapter(viewModel)
        binding.rvMyList.adapter = adapter

        viewModel.myList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.navToDetail.observe(viewLifecycleOwner) {
            it?.let {
                findNavController().navigate(HomeFragmentDirections.navToDetailFragment(it))
                viewModel.onNavToDetail()
            }
        }

        return binding.root
    }
}