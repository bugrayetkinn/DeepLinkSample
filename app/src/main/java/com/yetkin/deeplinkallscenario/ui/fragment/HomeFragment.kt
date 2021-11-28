package com.yetkin.deeplinkallscenario.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yetkin.deeplinkallscenario.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            fragment = this@HomeFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userName = args.userName ?: "deep link user is null"
    }

    fun goToProfile() {
        val profileDirections =
            HomeFragmentDirections.actionHomeFragmentToProfileFragment().also {
                it.accountId = 0
            }
        findNavController().navigate(profileDirections)
    }
}