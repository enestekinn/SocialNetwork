package com.enestekin.socialnetwork.feature_activity.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.enestekin.socialnetwork.core.domain.models.Activity
import com.enestekin.socialnetwork.core.util.Constants
import com.enestekin.socialnetwork.feature_activity.data.remote.ActivityApi
import com.enestekin.socialnetwork.feature_activity.domain.repository.ActivityRepository
import com.enestekin.socialnetwork.feature_post.data.paging.ActivitySource
import kotlinx.coroutines.flow.Flow

class ActivityRepositoryImpl(
    private val api: ActivityApi
): ActivityRepository {


    override val activities: Flow<PagingData<Activity>>
        get() = Pager(PagingConfig(pageSize = Constants.DEFAULT_PAGE_SIZE)) {
            ActivitySource(api)
        }.flow

}