package com.mbobiosio.home.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mbobiosio.common.base.BaseBindingFragment
import com.mbobiosio.home.R
import com.mbobiosio.home.databinding.FragmentHomeBinding
import com.mbobiosio.home.di.inject
import com.mbobiosio.home.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeFragment : BaseBindingFragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    override fun bindFragment(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            val description = viewModel.getDescription().plus(getString(R.string.home))

            toolBar.title = description

            fab.setOnClickListener {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun unbindFragment() {
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }
}
