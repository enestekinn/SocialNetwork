package com.enestekin.socialnetwork.feature_profile.domain.repository

import android.net.Uri
import androidx.paging.PagingData
import com.enestekin.socialnetwork.core.domain.models.Post
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.core.util.SimpleResource
import com.enestekin.socialnetwork.feature_profile.domain.model.Profile
import com.enestekin.socialnetwork.feature_profile.domain.model.Skill
import com.enestekin.socialnetwork.feature_profile.domain.model.UpdateProfileData
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {




    fun getPostsPaged(userId: String): Flow<PagingData<Post>>


    suspend fun  getProfile(userId: String): Resource<Profile>



    suspend fun updateProfile(
        updateProfileData: UpdateProfileData,
        bannerImageUri: Uri?,
        profilePictureUri: Uri?
    ): SimpleResource

    suspend fun getSkills(): Resource<List<Skill>>
}