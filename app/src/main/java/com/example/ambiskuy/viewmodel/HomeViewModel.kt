package com.example.ambiskuy.viewmodel

import androidx.lifecycle.ViewModel
import com.example.brain.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
}