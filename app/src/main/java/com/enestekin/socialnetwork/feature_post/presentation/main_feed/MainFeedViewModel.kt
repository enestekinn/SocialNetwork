package com.enestekin.socialnetwork.feature_post.presentation.main_feed

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.compose.collectAsLazyPagingItems
import com.enestekin.socialnetwork.core.presentation.util.Event
import com.enestekin.socialnetwork.core.presentation.util.UiEvent
import com.enestekin.socialnetwork.core.util.ParentType
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.feature_post.domain.use_case.PostUseCases
import com.enestekin.socialnetwork.feature_post.presentation.person_list.PostEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainFeedViewModel @Inject constructor(
    private val postUseCases: PostUseCases
) : ViewModel() {

    private val _state = mutableStateOf(MainFeedState())
    val state: State<MainFeedState> = _state

    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

val posts = postUseCases.getPostsForFollowsUserCase()
    .cachedIn(viewModelScope)

    fun onEvent(event: MainFeedEvent) {
        when(event){
            is MainFeedEvent.LoadMorePosts -> {
                _state.value = state.value.copy(
                    isLoadingNewPosts =  true
                )
            }
            is MainFeedEvent.LoadedPage -> {
             _state.value = state.value.copy(
                 isLoadingFirstTime = false,
                 isLoadingNewPosts = false
             )
            }
            is MainFeedEvent.LikedPost -> {
            }

        }
    }

    private fun toggleLikeForParent(
        parentId: String,
        isLiked: Boolean
    ) {

        viewModelScope.launch {
 val result = postUseCases.toggleLikeForParent(
     parentId = parentId,
     parentType = ParentType.Post.type,
     isLiked = isLiked
 )
            when(result){
                is Resource.Success -> {
                    _eventFlow.emit(PostEvent.OnLiked)
                }
                is Resource.Error -> {

                }
            }

        }
    }

}