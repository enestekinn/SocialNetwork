package com.enestekin.socialnetwork.feature_profile.data.repository

import android.net.Uri
import androidx.core.net.toFile
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.core.domain.data.remote.PostApi
import com.enestekin.socialnetwork.core.domain.models.Post
import com.enestekin.socialnetwork.core.util.Constants
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.core.util.SimpleResource
import com.enestekin.socialnetwork.core.util.UiText
import com.enestekin.socialnetwork.feature_post.data.paging.PostSource
import com.enestekin.socialnetwork.feature_profile.data.remote.ProfileApi
import com.enestekin.socialnetwork.feature_profile.domain.model.Profile
import com.enestekin.socialnetwork.feature_profile.domain.model.Skill
import com.enestekin.socialnetwork.feature_profile.domain.model.UpdateProfileData
import com.enestekin.socialnetwork.feature_profile.domain.repository.ProfileRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import java.io.IOException

class ProfileRepositoryImpl(
    private val profileApi: ProfileApi,
    private val postApi: PostApi,
    private val gson: Gson
) : ProfileRepository {
    override suspend fun getProfile(userId: String): Resource<Profile> {

        println("getProfile:$userId   ProfileRepositoryImpl")
        return try {
        val response = profileApi.getProfile(userId)

            println("getProfile:${response.successful}   ProfileRepositoryImpl")


            if (response.successful) {
                Resource.Success(response.data?.toProfile())
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }

    }



    override suspend fun updateProfile(
        updateProfileData: UpdateProfileData,
        bannerImageUri: Uri?,
        profilePictureUri: Uri?
    ): SimpleResource {

        val bannerFile = bannerImageUri?.toFile()
        val profilePictureFile = profilePictureUri?.toFile()


        return try {
            val response = profileApi.updateProfile(
                bannerImage = bannerFile?.let{
                    MultipartBody.Part
                        .createFormData(
                            "banner_image",
                            bannerFile.name,
                            bannerFile.asRequestBody()
                        )
                },
                profilePicture = profilePictureFile?.let {
                    MultipartBody.Part
                        .createFormData(
                            "profile_picture",
                            profilePictureFile.name,
                            profilePictureFile.asRequestBody()
                        )
                },
                updateProfileData = MultipartBody.Part
                    .createFormData(
                        "update_profile_data",
                        gson.toJson(updateProfileData)
                    )

            )



            if (response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getSkills(): Resource<List<Skill>> {
        return try {
            val response = profileApi.getSkills()
            Resource.Success(
                data = response.map { it.toSkill() }
            )


    }catch (e: IOException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )

        }  catch (e: HttpException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override fun getPostsPaged(userId: String): Flow<PagingData<Post>> {
       return  Pager(PagingConfig(pageSize = Constants.PAGE_SIZE_POSTS)){
            PostSource(postApi,PostSource.Source.Profile(userId))
        }.flow
    }


}