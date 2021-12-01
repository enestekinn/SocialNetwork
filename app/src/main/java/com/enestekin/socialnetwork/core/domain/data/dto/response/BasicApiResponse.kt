package com.enestekin.socialnetwork.core.domain.data.dto.response


// api sometimes return nothing but sometimes data so we added val data
data class BasicApiResponse<T>(
    val successful: Boolean,
    val message: String? = null,
    val data: T? = null
)