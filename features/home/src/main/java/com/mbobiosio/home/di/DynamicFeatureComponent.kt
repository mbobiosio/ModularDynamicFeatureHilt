package com.mbobiosio.home.di

import android.content.Context
import com.mbobiosio.home.presentation.HomeFragment
import com.mbobiosio.modularapp.di.DynamicFeatureDependencies
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [DynamicFeatureDependencies::class],
    modules = [
        DynamicFeatureModule::class
    ]
)
interface DynamicFeatureComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            dependencies: DynamicFeatureDependencies
        ): DynamicFeatureComponent
    }

    fun inject(fragment: HomeFragment)
}

internal fun HomeFragment.inject() {
    DaggerDynamicFeatureComponent.factory().create(
        requireContext(),
        dagger.hilt.android.EntryPointAccessors.fromApplication(
            requireContext().applicationContext,
            DynamicFeatureDependencies::class.java
        )
    ).inject(this)
}
