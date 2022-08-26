package com.example.android.gdgfinder.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.android.gdgfinder.R
import com.example.android.gdgfinder.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: VM_Home

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val binding = HomeFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[VM_Home::class.java]
        binding.x = viewModel
        binding.lifecycleOwner = this

        viewModel.navigateToSearch.observe(viewLifecycleOwner, Observer {
                if (it == true) {
                    val navController = binding.root.findNavController()
                    navController.navigate(R.id.action_homeFragment_to_gdgListFragment)
                    viewModel.navigationDone_ToSearch()
                }
            })

        return binding.root
    }
}
