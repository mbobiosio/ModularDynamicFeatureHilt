package com.mbobiosio.home.viewmodel

import androidx.lifecycle.ViewModel
import com.mbobiosio.domain.SampleRepository
import javax.inject.Inject

/*
* Created by Mbuodile Obiosio on May 06, 2022.
* Twitter: @cazewonder
* Nigeria
*/
class HomeViewModel @Inject constructor(private val repository: SampleRepository
): ViewModel() {

    fun getDescription() = repository.getDescription()
}