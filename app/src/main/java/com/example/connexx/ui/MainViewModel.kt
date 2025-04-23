package com.example.connexx.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.hammerhead.karooext.KarooSystemService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val karooSystemService: KarooSystemService
) : ViewModel() {
    private val _uiState = MutableStateFlow(ConnexxUiState())
    val uiState: StateFlow<ConnexxUiState> = _uiState.asStateFlow()
}