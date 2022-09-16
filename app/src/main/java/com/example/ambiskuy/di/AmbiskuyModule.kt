package com.example.ambiskuy.di

import com.example.brain.data.datastore.DataStoreSource
import com.example.brain.data.local.LocalDataSource
import com.example.brain.data.remote.RemoteDataSource
import com.example.brain.data.repository.Repository
import com.example.brain.di.BrainModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AmbiskuyModule {
    @Singleton
    @Provides
    fun provideRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource,
        dataStoreSource: DataStoreSource
    ) = Repository(
        localDataSource = localDataSource,
        remoteDataSource = remoteDataSource,
        dataStoreSource = dataStoreSource
    )
}