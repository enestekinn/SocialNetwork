package com.enestekin.socialnetwork.feature_activity.domain.use_case

import androidx.paging.PagingData
import com.enestekin.socialnetwork.core.domain.models.Activity
import com.enestekin.socialnetwork.feature_activity.domain.repository.ActivityRepository
import kotlinx.coroutines.flow.Flow

class GetActivityUseCase(
    private val repository: ActivityRepository
) {

     operator fun invoke(): Flow<PagingData<Activity>> {
        return repository.activities
    }
}