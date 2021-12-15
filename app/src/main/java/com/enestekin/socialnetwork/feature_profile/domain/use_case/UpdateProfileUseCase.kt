package com.enestekin.socialnetwork.feature_profile.domain.use_case

import android.net.Uri
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.core.util.SimpleResource
import com.enestekin.socialnetwork.core.util.UiText
import com.enestekin.socialnetwork.feature_profile.domain.model.UpdateProfileData
import com.enestekin.socialnetwork.feature_profile.domain.repository.ProfileRepository
import com.enestekin.socialnetwork.feature_profile.util.ProfileConstants

class UpdateProfileUseCase(
    private val repository: ProfileRepository
) {


    suspend operator  fun invoke(
        updateProfileData: UpdateProfileData,
        profilePictureUri: Uri?,
        bannerUri: Uri?,
    ): SimpleResource {

        if (updateProfileData.username.isBlank()){
            return Resource.Error(
                uiText = UiText.StringResource(R.string.error_username_empty)
            )
        }
        val isValidGithubUrl = ProfileConstants.GITHUB_PROFILE_REGEX.matches(updateProfileData.gitHubUrl)
        if (!isValidGithubUrl){
            return  Resource.Error(
                uiText = UiText.StringResource(R.string.error_invalid_github_url)
            )
        }
        val isValidInstagramUrl = ProfileConstants.INSTAGRAM_PROFILE_REGEX.matches(updateProfileData.instagramUrl)
        if (!isValidInstagramUrl){
            return  Resource.Error(
                uiText = UiText.StringResource(R.string.error_invalid_instagram_url)
            )
        }
        val isValidLinkedInUrl = ProfileConstants.LINKED_IN_PROFILE_REGEX.matches(updateProfileData.linkedInUrl)
        if (!isValidLinkedInUrl){
            return  Resource.Error(
                uiText = UiText.StringResource(R.string.error_invalid_linked_in_url)
            )
        }
        return repository.updateProfile(
            updateProfileData = updateProfileData,
            profilePictureUri = profilePictureUri,
            bannerImageUri = bannerUri
        )
    }
}