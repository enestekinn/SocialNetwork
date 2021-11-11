package com.enestekin.socialnetwork.feature_auth.data.remote

import com.enestekin.socialnetwork.core.domain.data.dto.response.BasicApiResponse
import com.enestekin.socialnetwork.feature_auth.data.dto.request.CreateAccountRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/api/user/create")
    suspend fun register(
        @Body request: CreateAccountRequest
    ): BasicApiResponse

    companion object {
        const val BASE_URL = "http://10.0.2.2:8001/"
    }
}