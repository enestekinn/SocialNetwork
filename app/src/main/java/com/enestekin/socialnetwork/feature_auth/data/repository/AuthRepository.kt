package com.enestekin.socialnetwork.feature_auth.data.repository

import com.enestekin.socialnetwork.core.util.SimpleResource

interface AuthRepository {

    suspend fun register(
        email: String,
        username: String,
        password: String
    ): SimpleResource
}