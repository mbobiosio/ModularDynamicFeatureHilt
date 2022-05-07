package com.mbobiosio.modularapp.di

import com.mbobiosio.data.SampleRepositoryImpl
import com.mbobiosio.domain.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSampleRepository(): SampleRepository = SampleRepositoryImpl()
}
