package com.enestekin.socialnetwork.feature_profile.domain.repository

import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.feature_profile.domain.model.Profile

interface ProfileRepository {

    suspend fun  getProfile(userId: String): Resource<Profile>
}