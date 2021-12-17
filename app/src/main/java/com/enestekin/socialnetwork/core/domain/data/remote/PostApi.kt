package com.enestekin.socialnetwork.core.domain.data.remote

import com.enestekin.socialnetwork.core.domain.data.dto.response.BasicApiResponse
import com.enestekin.socialnetwork.core.domain.models.Post
import okhttp3.MultipartBody
import retrofit2.http.*

interface PostApi {

    @GET("/api/post/get/")
    suspend fun getPostsForFollows(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<Post>

    @GET("/api/user/posts")
    suspend fun getPostsForProfile(
        @Query("userId") userId: String,
        @Query("page") page:Int,
        @Query("pageSize") pageSize: Int
    ): List<Post>

    // making multipart request
    @Multipart
    @POST("/api/post/create")
    suspend fun createPost(
        @Part postData: MultipartBody.Part,
        @Part postImage: MultipartBody.Part,
    ): BasicApiResponse<Unit>

    companion object {
        //const val BASE_URL = "http://192.168.0.102:8001/"
        const val BASE_URL = "http://192.168.1.9:8001/"
      //  const val BASE_URL = "http://10.0.2.2:8001/"


    }
}