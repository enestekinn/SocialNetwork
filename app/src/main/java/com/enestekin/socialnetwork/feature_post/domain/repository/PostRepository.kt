package com.enestekin.socialnetwork.feature_post.domain.repository

import androidx.paging.PagingData
import com.enestekin.socialnetwork.core.domain.models.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

val posts : Flow<PagingData<Post>>
}