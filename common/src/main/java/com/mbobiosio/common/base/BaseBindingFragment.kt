package com.mbobiosio.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseBindingFragment : Fragment() {

    protected abstract fun bindFragment(inflater: LayoutInflater, container: ViewGroup?): View

    protected abstract fun setupUI(view: View, savedInstanceState: Bundle?)

    protected abstract fun unbindFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return bindFragment(inflater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbindFragment()
    }
}
