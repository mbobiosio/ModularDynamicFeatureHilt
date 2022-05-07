package com.mbobiosio.account.viewmodel

import androidx.lifecycle.ViewModel
import com.mbobiosio.domain.SampleRepository
import javax.inject.Inject

class AccountViewModel @Inject constructor(private val repository: SampleRepository) : ViewModel() {
    fun getDescription() = repository.getDescription()
}
