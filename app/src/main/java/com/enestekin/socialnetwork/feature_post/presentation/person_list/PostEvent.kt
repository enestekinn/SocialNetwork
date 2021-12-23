package com.enestekin.socialnetwork.feature_post.presentation.person_list

import com.enestekin.socialnetwork.core.presentation.util.Event

sealed class PostEvent : Event(){
    object OnLiked: PostEvent()


}
