package com.enestekin.socialnetwork.feature_auth.data.remote

import com.enestekin.socialnetwork.core.domain.data.dto.response.BasicApiResponse
import com.enestekin.socialnetwork.feature_auth.data.remote.request.CreateAccountRequest
import com.enestekin.socialnetwork.feature_auth.data.remote.request.LoginRequest
import com.enestekin.socialnetwork.feature_auth.data.remote.response.AuthResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @POST("/api/user/create")
    suspend fun register(
        @Body request: CreateAccountRequest
    ): BasicApiResponse<Unit>

    @POST("/api/user/login")
    suspend fun login(
        @Body request: LoginRequest
    ): BasicApiResponse<AuthResponse>

    @GET("/api/user/authenticate")
    suspend fun authenticate()

    companion object {
        //const val BASE_URL = "http://192.168.0.102:8001/"
        const val BASE_URL = "http://192.168.1.5:8001/"
     //   const val BASE_URL = "http://10.0.2.2:8001/"


    }
}