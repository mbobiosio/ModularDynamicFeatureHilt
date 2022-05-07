package com.mbobiosio.modularapp

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.mbobiosio.common.base.BaseBindingActivity
import com.mbobiosio.common.util.NavManager
import com.mbobiosio.modularapp.databinding.ActivityMainBinding
import com.mbobiosio.modularapp.util.navigateSafe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseBindingActivity() {
    private lateinit var binding: ActivityMainBinding

    private val navController get() = findNavController(R.id.nav_host_container)

    private val navManager by lazy {
        NavManager()
    }

    override fun setLayout(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun setupUI(savedInstanceState: Bundle?) {

        with(binding) {

            bottomNavigationView.setupWithNavController(navController)
            bottomNavigationView.setOnItemReselectedListener {  }

            navManager.setOnNavEvent {
                val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_container)
                val currentFragment = navHostFragment?.childFragmentManager?.fragments?.get(0)

                currentFragment?.navigateSafe(it)
            }

        }
    }
}
