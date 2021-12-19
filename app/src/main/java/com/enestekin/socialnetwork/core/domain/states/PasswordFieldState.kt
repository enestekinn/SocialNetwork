package com.enestekin.socialnetwork.core.domain.states

import com.enestekin.socialnetwork.core.util.Error

data class PasswordTextFieldState(
    val text: String = "",
    val error: Error? = null,
    val isPasswordVisible: Boolean = false
)