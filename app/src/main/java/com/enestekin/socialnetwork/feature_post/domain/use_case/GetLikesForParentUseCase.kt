package com.enestekin.socialnetwork.feature_post.domain.use_case

import com.enestekin.socialnetwork.core.domain.models.UserItem
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.feature_post.domain.repository.PostRepository

class GetLikesForParentUseCase (
    private val repository: PostRepository
        ){
    suspend operator fun invoke(parentId: String): Resource<List<UserItem>>{
        return  repository.getLikesForParent(parentId)
    }
}