package com.enestekin.socialnetwork.core.presentation.util

import com.enestekin.socialnetwork.core.util.UiText

sealed class UiEvent {
    data class SnackbarEvent(val uiText: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()

}