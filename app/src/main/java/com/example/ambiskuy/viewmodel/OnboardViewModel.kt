package com.example.ambiskuy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brain.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {
    fun saveFirstTimeOpenAppState(state:Boolean){
        viewModelScope.launch {
            repository.setIsFirstTimeOpenApp(state)
        }
    }
}