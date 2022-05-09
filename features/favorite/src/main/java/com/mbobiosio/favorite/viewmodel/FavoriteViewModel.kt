package com.mbobiosio.favorite.viewmodel

import androidx.lifecycle.ViewModel
import com.mbobiosio.domain.SampleRepository
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    private val repository: SampleRepository
) : ViewModel() {
    fun getDescription() = repository.getDescription()
}
