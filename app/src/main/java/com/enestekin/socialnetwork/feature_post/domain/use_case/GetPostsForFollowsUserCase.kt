package com.enestekin.socialnetwork.feature_post.domain.use_case

import androidx.paging.PagingData
import com.enestekin.socialnetwork.core.domain.models.Post
import com.enestekin.socialnetwork.core.util.Constants
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.feature_post.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostsForFollowsUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
         page:Int,
         pageSize: Int = Constants.DEFAULT_PAGE_SIZE
     ): Resource<List<Post>> {
       return repository.getPostsForFollows(page,pageSize)
    }
}