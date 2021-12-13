package com.enestekin.socialnetwork.feature_profile.presentation.edit_profile.util


sealed class EditProfileError : Error() {
    object FieldEmpty: EditProfileError()
}