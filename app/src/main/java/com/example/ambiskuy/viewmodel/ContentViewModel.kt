package com.example.ambiskuy.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ambiskuy.helper.BottomMenuItem
import com.example.brain.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {
    val bottomBarState = mutableStateOf(BottomMenuItem.HomeScreen)
}