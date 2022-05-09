package com.mbobiosio.favorite.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mbobiosio.common.base.BaseBindingFragment
import com.mbobiosio.favorite.R
import com.mbobiosio.favorite.databinding.FavoriteFragmentBinding
import com.mbobiosio.favorite.di.inject
import com.mbobiosio.favorite.viewmodel.FavoriteViewModel
import javax.inject.Inject

class FavoriteFragment : BaseBindingFragment() {

    private var _binding: FavoriteFragmentBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: FavoriteViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[FavoriteViewModel::class.java]
    }

    override fun bindFragment(inflater: LayoutInflater, container: ViewGroup?): View {
        _binding = FavoriteFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupUI(view: View, savedInstanceState: Bundle?) {

        with(binding) {
            val description = viewModel.getDescription().plus(getString(R.string.favorite))

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
