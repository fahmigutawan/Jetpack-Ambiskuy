package com.example.brain.di

import android.content.Context
import com.example.brain.data.datastore.DataStoreSource
import com.example.brain.data.local.LocalDataSource
import com.example.brain.data.remote.RemoteDataSource
import com.example.brain.data.repository.Repository
import com.example.brain.utils.AppGoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
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
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()

    @Singleton
    @Provides
    fun provideAppGoogleSignIn(@ApplicationContext context: Context) = AppGoogleSignIn(context)

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        auth: FirebaseAuth,
        appGoogleSignIn: AppGoogleSignIn,
        firestore: FirebaseFirestore
    ) = RemoteDataSource(auth = auth, firestore = firestore, appGoogleSignIn = appGoogleSignIn)

    @Singleton
    @Provides
    fun provideLocalDataSource() = LocalDataSource()

    @Singleton
    @Provides
    fun provideDataStoreSource(@ApplicationContext context: Context) = DataStoreSource(context)
}