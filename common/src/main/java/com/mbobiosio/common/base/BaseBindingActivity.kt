package com.mbobiosio.common.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseBindingActivity : AppCompatActivity() {

    protected abstract fun setLayout(): View

    protected abstract fun setupUI(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        setupUI(savedInstanceState)
    }
}
