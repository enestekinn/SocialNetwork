package com.enestekin.socialnetwork.presentation.activity

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.presentation.activity.components.ActivityItem
import com.enestekin.socialnetwork.presentation.components.StandardToolbar
import com.enestekin.socialnetwork.presentation.domain.models.Activity
import com.enestekin.socialnetwork.presentation.domain.util.ActivityAction
import com.enestekin.socialnetwork.presentation.domain.util.DateFormatUtil
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceMedium
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceSmall
import kotlin.random.Random

@Composable
fun ActivityScreen(
    navController: NavController,
    viewModel: ActivityViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_activity),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },

            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,

            )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding =  PaddingValues(SpaceMedium)
        ) {
            items(20) {
                ActivityItem(
                    activity = Activity(
                        username = "Enes Tekin",
                        actionType = if (Random.nextInt(2) == 0){
                            ActivityAction.LikedPost
                        }else ActivityAction.CommentedOnPost,
                        formattedTime = DateFormatUtil.timeStampToFormattedString(
                            System.currentTimeMillis(), "MMM dd, HH:mm"
                        )
                    ),
                    modifier = Modifier
                        .padding(SpaceSmall)
                )
                if (it < 19){ // we have 20 items no need  spacing in last item
                    Spacer(modifier = Modifier.height(SpaceMedium))
                }
            }
        }
    }


}