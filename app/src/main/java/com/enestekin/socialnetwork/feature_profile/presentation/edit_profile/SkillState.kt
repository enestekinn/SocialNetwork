package com.enestekin.socialnetwork.feature_profile.presentation.edit_profile

import com.enestekin.socialnetwork.feature_profile.domain.model.Skill

data class SkillState(
    val skills: List<Skill> = emptyList(),
    val selectedSkills: List<Skill> = emptyList(),
)