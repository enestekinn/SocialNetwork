package com.enestekin.socialnetwork.feature_auth.domain.use_case

import com.enestekin.socialnetwork.core.util.SimpleResource
import com.enestekin.socialnetwork.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase (
    private val repository: AuthRepository
        ){
    suspend operator fun invoke(): SimpleResource {
        return repository.authenticate()
    }
}