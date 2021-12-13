package com.enestekin.socialnetwork.feature_post.presentation.main_feed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.core.presentation.components.Post
import com.enestekin.socialnetwork.core.presentation.components.StandardToolbar
import com.enestekin.socialnetwork.core.util.Screen
import kotlinx.coroutines.launch

@Composable
fun MainFeedScreen(
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    scaffoldState: ScaffoldState,
    viewModel: MainFeedViewModel = hiltViewModel()
) {
    val posts = viewModel.posts.collectAsLazyPagingItems()
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        StandardToolbar(
            onNavigateUp = onNavigateUp,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },

            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,
            navActions = {
                IconButton(
                    onClick = {
                       onNavigate(Screen.SearchScreen.route)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onBackground
                    )

                }
            }
        )

        Box(modifier = Modifier.fillMaxSize()){
            if (state.isLoadingFirstTime){
                CircularProgressIndicator(modifier = Modifier.align(Center))
            }
            LazyColumn {

                items(posts){ posts ->
                    Post(
                        post = com.enestekin.socialnetwork.core.domain.models.Post(
                            username = posts?.username ?: "",
                            imageUrl = posts?.imageUrl ?: "",
                            profilePictureUrl = posts?.profilePictureUrl ?: "",
                            description = posts?.description ?: "",
                            likeCount = posts?.likeCount ?: 0,
                            commentCount = posts?.commentCount ?: 0
                        ),
                        onPostClicked = {
                            onNavigate(Screen.PostDetailScreen.route)
                        }
                    )
                }

                item {
                    if (state.isLoadingNewPosts){
                        CircularProgressIndicator(modifier = Modifier.align(BottomCenter))
                    }
                }
                posts.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            viewModel.onEvent(MainFeedEvent.LoadedPage)
                        }
                        loadState.append is LoadState.Loading -> {
                            viewModel.onEvent(MainFeedEvent.LoadMorePosts)
                        }
                        loadState.append is LoadState.NotLoading -> {
                            viewModel.onEvent(MainFeedEvent.LoadedPage)
                        }
                        loadState.append is LoadState.Error -> {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Error"
                                )
                            }

                        }

                    }
                }
            }

        }




    }
}