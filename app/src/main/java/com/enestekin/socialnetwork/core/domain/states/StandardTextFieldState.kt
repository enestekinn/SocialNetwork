package com.enestekin.socialnetwork.core.domain.states

import com.enestekin.socialnetwork.core.util.Error


data class StandardTextFieldState(
    val text: String = "",
    val error: Error? = null
)
