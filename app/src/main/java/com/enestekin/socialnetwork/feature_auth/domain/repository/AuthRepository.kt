package com.enestekin.socialnetwork.feature_auth.domain.repository

import com.enestekin.socialnetwork.core.util.SimpleResource

interface AuthRepository {

    suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource

    suspend fun login(
        email: String,
        password: String
    ): SimpleResource

    suspend fun  authenticate(): SimpleResource
}