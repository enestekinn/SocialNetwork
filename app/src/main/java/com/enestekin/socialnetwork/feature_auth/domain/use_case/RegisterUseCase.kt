package com.enestekin.socialnetwork.feature_auth.domain.use_case

import com.enestekin.socialnetwork.core.domain.util.ValidationUtil
import com.enestekin.socialnetwork.feature_auth.data.repository.AuthRepository
import com.enestekin.socialnetwork.feature_auth.domain.models.RegisterResult

class RegisterUseCase(
    private val repository: AuthRepository
){
suspend operator fun invoke(
    email: String,
    username: String,
    password: String

): RegisterResult {
    val emailError = ValidationUtil.validateEmail(email)
    val usernameError = ValidationUtil.validateUsername(username)
    val passwordError = ValidationUtil.validatePassword(password)

    if(emailError != null || usernameError != null || passwordError != null) {
        return RegisterResult(
            emailError = emailError,
            usernameError = usernameError,
            passwordError = passwordError,
        )
    }

    val result = repository.register(email.trim(), username.trim(), password.trim())

    return RegisterResult(
    result = result
    )
}
}