package com.enestekin.socialnetwork.feature_post.data.repository

import android.content.Context
import android.net.Uri
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.core.domain.models.Post
import com.enestekin.socialnetwork.core.domain.util.getFileName
import com.enestekin.socialnetwork.core.util.Constants
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.core.util.SimpleResource
import com.enestekin.socialnetwork.core.util.UiText
import com.enestekin.socialnetwork.feature_post.data.data_source.paging.PostSource
import com.enestekin.socialnetwork.feature_post.data.data_source.remote.PostApi
import com.enestekin.socialnetwork.feature_post.data.data_source.remote.request.CreatePostRequest
import com.enestekin.socialnetwork.feature_post.domain.repository.PostRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException


class PostRepositoryImpl(
    private val api: PostApi,
    private val gson: Gson,
    private val appContext: Context
): PostRepository {

    override val posts: Flow<PagingData<Post>>
        get() = Pager(PagingConfig(pageSize = Constants.PAGE_SIZE_POSTS)) {
            PostSource(api)
        }.flow

    override suspend fun createPost(
        description: String,
        imageUri: Uri
    ): SimpleResource {
        val request = CreatePostRequest(description)

        val file = withContext(Dispatchers.IO){

            appContext.contentResolver.openInputStream(imageUri)?.use { inputStream ->

            }
         appContext.contentResolver.openFileDescriptor(imageUri,"r")?.let { fd ->

             val inputStream = FileInputStream(fd.fileDescriptor)
             val file = File(
                 appContext.cacheDir,
                 appContext.contentResolver.getFileName(imageUri),
             )
             val outputStream = FileOutputStream(file)
                 inputStream.copyTo(outputStream)
             file
         }
        } ?: return Resource.Error(
                uiText = UiText.StringResource(R.string.error_file_not_found)
            )

        return try {

            val response = api.createPost(
                postData = MultipartBody.Part
                        // post_data from ktor
                    .createFormData(
                        "post_data",
                    gson.toJson(request)
                    ),
                postImage =MultipartBody.Part
                    .createFormData(
                        name = "post_image",
                        filename = file.name,
                        body = file.asRequestBody()
                    )
            )
            if (response.successful){
                Resource.Success(Unit)
            }else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }

        }catch (e: IOException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        }catch (e: HttpException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }
}