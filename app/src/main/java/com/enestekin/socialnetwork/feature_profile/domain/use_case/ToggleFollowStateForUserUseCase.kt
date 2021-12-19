package com.enestekin.socialnetwork.feature_profile.domain.use_case

import com.enestekin.socialnetwork.core.util.SimpleResource
import com.enestekin.socialnetwork.feature_profile.domain.repository.ProfileRepository

class ToggleFollowStateForUserUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String,isFollowing: Boolean): SimpleResource {
        return if (isFollowing){
            repository.unfollowUser(userId)
        }else {
            repository.followUser(userId)
        }
    }
}