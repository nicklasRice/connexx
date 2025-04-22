package com.example.connexx

import android.content.Context
import androidx.lifecycle.ViewModel
import io.hammerhead.karooext.KarooSystemService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(context: Context) : ViewModel() {
    private val karooSystem: KarooSystemService = KarooSystemService(context)

    private val _uiState = MutableStateFlow(ConnexxUiState())
    val uiState: StateFlow<ConnexxUiState> = _uiState.asStateFlow()
}