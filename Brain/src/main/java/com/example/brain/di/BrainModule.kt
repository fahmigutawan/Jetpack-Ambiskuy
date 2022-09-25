package com.example.brain.di

import android.content.Context
import com.example.brain.data.datastore.DataStoreSource
import com.example.brain.data.local.LocalDataSource
import com.example.brain.data.remote.RemoteDataSource
import com.example.brain.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BrainModule {
    @Singleton
    @Provides
    fun provideRemoteDataSource() = RemoteDataSource()

    @Singleton
    @Provides
    fun provideLocalDataSource() = LocalDataSource()

    @Singleton
    @Provides
    fun provideDataStoreSource(@ApplicationContext context: Context) = DataStoreSource(context)
}