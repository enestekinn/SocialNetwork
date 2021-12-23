package com.enestekin.socialnetwork.feature_profile.domain.use_case

import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.feature_profile.domain.model.Skill
import com.enestekin.socialnetwork.core.domain.repository.ProfileRepository

class GetSkillsUseCase(
    private val repository: ProfileRepository
) {
    suspend operator fun invoke(): Resource<List<Skill>>{
        return   repository.getSkills()
    }
}