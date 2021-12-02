package com.enestekin.socialnetwork.feature_post.domain.repository

import android.net.Uri
import androidx.paging.PagingData
import com.enestekin.socialnetwork.core.domain.models.Post
import com.enestekin.socialnetwork.core.util.SimpleResource
import kotlinx.coroutines.flow.Flow

interface PostRepository {

val posts : Flow<PagingData<Post>>

// username is coming from userid
suspend fun createPost(description: String, imageUri: Uri): SimpleResource
}