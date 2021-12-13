package com.enestekin.socialnetwork.feature_auth.data.remote.request

data class CreateAccountRequest(
    val email: String,
    val username: String,
    val password: String
)