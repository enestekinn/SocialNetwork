package com.enestekin.socialnetwork.feature_profile.domain.use_case

import com.enestekin.socialnetwork.core.domain.models.UserItem
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.core.domain.repository.ProfileRepository

class SearchUserUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(query: String): Resource<List<UserItem>>{
        if (query.isBlank()){
            return  Resource.Success(data = emptyList())
        }
        return repository.searchUser(query)
    }
}