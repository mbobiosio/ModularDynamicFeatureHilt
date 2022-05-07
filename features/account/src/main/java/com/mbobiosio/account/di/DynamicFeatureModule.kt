package com.mbobiosio.account.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mbobiosio.account.viewmodel.AccountViewModel
import com.mbobiosio.modularapp.di.ViewModelFactory
import com.mbobiosio.modularapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ViewModelComponent::class)
abstract class DynamicFeatureModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AccountViewModel::class)
    internal abstract fun bindDynamicFeatureViewModel(viewModel: AccountViewModel): ViewModel
}
