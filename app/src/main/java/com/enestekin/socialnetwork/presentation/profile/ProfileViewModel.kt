package com.enestekin.socialnetwork.presentation.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(

): ViewModel() {


    private val _expandedRatio = mutableStateOf(1f)
    val expandedRatio: State<Float> = _expandedRatio

    fun expandedRatio(ratio: Float ) {
        _expandedRatio.value = ratio
    }
    private val _toolbarOffsetY = mutableStateOf<Float>(0f)
    val toolbarOffsetY: State<Float> = _toolbarOffsetY

    fun setToolbarOffsetY(value: Float) {
        _toolbarOffsetY.value = value
    }
}    