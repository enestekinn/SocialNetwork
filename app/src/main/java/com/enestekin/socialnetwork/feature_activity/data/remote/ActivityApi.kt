package com.enestekin.socialnetwork.feature_activity.data.remote

import com.enestekin.socialnetwork.core.util.Constants
import com.enestekin.socialnetwork.feature_activity.data.remote.dto.ActivityDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ActivityApi {

    @GET("/api/activity/get")
    suspend fun getActivities(
        @Query("page") page: Int = 0,
        @Query("pageSize") pageSize: Int = Constants.DEFAULT_PAGE_SIZE

    ): List<ActivityDto>

    companion object {
        //const val BASE_URL = "http://192.168.0.102:8001/"
        const val BASE_URL = "http://192.168.1.3:8001/"
        //   const val BASE_URL = "http://10.0.2.2:8001/"


    }

}