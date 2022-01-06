package com.kappstudio.videoplayerlab.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kappstudio.videoplayerlab.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        val adapter = ProductAdapter()
        binding.rvMyList.adapter = adapter

        viewModel.myList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }
}