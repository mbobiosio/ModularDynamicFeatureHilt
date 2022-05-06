package com.mbobiosio.account.di

import android.content.Context
import com.mbobiosio.account.presentation.AccountFragment
import com.mbobiosio.modularapp.di.DynamicFeatureDependencies
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.EntryPointAccessors

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

    fun inject(fragment: AccountFragment)
}

internal fun AccountFragment.inject() {
    DaggerDynamicFeatureComponent.factory().create(
        requireContext(),
        EntryPointAccessors.fromApplication(
            requireContext().applicationContext,
            DynamicFeatureDependencies::class.java
        )
    ).inject(this)
}
