package com.enestekin.socialnetwork.feature_profile.domain.use_case

import androidx.paging.PagingData
import com.enestekin.socialnetwork.core.domain.models.Post
import com.enestekin.socialnetwork.feature_profile.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class GetPostsForProfileUseCase(
    private val repository: ProfileRepository
){
    operator fun invoke(userId: String): Flow<PagingData<Post>> {
        return repository.getPostsPaged(userId)
    }
}