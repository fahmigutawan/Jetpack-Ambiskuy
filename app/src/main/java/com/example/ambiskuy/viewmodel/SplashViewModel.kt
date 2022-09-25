package com.example.ambiskuy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brain.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {
    suspend fun checkFirstTimeOpenAppState(onRetrieved:(Boolean) -> Unit){
            repository.isFirstTimeOpenApp().collect{
                onRetrieved(it)
            }
    }
}