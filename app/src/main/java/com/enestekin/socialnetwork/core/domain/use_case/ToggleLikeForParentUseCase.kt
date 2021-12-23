package com.enestekin.socialnetwork.core.domain.use_case

import com.enestekin.socialnetwork.core.util.SimpleResource
import com.enestekin.socialnetwork.feature_post.domain.repository.PostRepository

class ToggleLikeForParentUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(parentId: String,parentType: Int,isLiked: Boolean): SimpleResource {
        return if (isLiked){
            repository.unLikeParent(parentId,parentType)
        }else {
            repository.likeParent(parentId,parentType)
        }
    }
}