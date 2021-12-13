package com.enestekin.socialnetwork.feature_profile.domain.use_case

import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.feature_profile.domain.model.Profile
import com.enestekin.socialnetwork.feature_profile.domain.repository.ProfileRepository

class GetProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String): Resource<Profile> {
        return repository.getProfile(userId)
    }
}