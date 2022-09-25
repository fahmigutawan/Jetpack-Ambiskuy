package com.example.ambiskuy.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.brain.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {
    val emailState = mutableStateOf("")
    val passwordState = mutableStateOf("")
}