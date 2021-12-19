package com.enestekin.socialnetwork.feature_profile.presentation.edit_profile.util

import com.enestekin.socialnetwork.core.util.Error


sealed class EditProfileError : Error() {
    object FieldEmpty: EditProfileError()
}