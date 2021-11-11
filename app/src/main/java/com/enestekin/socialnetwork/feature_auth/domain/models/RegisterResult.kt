package com.enestekin.socialnetwork.feature_auth.domain.models

import com.enestekin.socialnetwork.core.util.SimpleResource
import com.enestekin.socialnetwork.feature_auth.presentation.util.AuthError

data class RegisterResult(
    val emailError: AuthError? = null,
    val usernameError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)