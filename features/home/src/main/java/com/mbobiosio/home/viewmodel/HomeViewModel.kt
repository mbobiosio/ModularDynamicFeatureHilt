package com.mbobiosio.home.viewmodel

import androidx.lifecycle.ViewModel
import com.mbobiosio.domain.SampleRepository
import javax.inject.Inject

/**
* @author Mbuodile Obiosio
* Twitter: @cazewonder
* Nigeria
*/
class HomeViewModel @Inject constructor(
    private val repository: SampleRepository
) : ViewModel() {

    fun getDescription() = repository.getDescription()
}
