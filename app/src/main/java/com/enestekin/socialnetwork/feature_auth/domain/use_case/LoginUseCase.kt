package com.enestekin.socialnetwork.feature_auth.domain.use_case

import com.enestekin.socialnetwork.feature_auth.data.repository.AuthRepository
import com.enestekin.socialnetwork.feature_auth.domain.models.LoginResult
import com.enestekin.socialnetwork.feature_auth.presentation.util.AuthError

class LoginUseCase (
    private val repository: AuthRepository
        ){

    suspend operator fun  invoke(email: String, password: String): LoginResult{
        println("HELLO WORLD")
        val emailError  = if (email.isBlank()) AuthError.FieldEmpty else null
        val passwordError  = if (password.isBlank()) AuthError.FieldEmpty else null
        if (emailError != null && passwordError != null){
            return LoginResult(emailError,passwordError)
        }
        return LoginResult(
            result = repository.login(email, password)

        )
    }

}