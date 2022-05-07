package com.mbobiosio.favorite.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mbobiosio.favorite.viewmodel.FavoriteViewModel
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
    @ViewModelKey(FavoriteViewModel::class)
    internal abstract fun bindDynamicFeatureViewModel(viewModel: FavoriteViewModel): ViewModel
}
