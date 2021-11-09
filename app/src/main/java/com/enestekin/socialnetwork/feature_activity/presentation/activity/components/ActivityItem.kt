package com.enestekin.socialnetwork.feature_activity.presentation.activity.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.domain.models.Activity
import com.enestekin.socialnetwork.domain.util.ActivityAction
import com.enestekin.socialnetwork.core.presentation.ui.theme.SpaceSmall

@Composable
fun ActivityItem(
    activity: Activity,
    modifier: Modifier = Modifier
) {
    
    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.onSurface,
        elevation = 5.dp
        ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceSmall),
            horizontalArrangement = Arrangement.SpaceBetween, // [*     *]
        verticalAlignment = Alignment.CenterVertically
        ){

            // username *comment on* your post
            // username *liked*  your post
            val fillerText = when(activity.actionType){
                ActivityAction.CommentedOnPost ->
                    stringResource(id = R.string.commented_on)
                ActivityAction.LikedPost ->
                    stringResource(id = R.string.liked)
                 ActivityAction.FollowedYou ->
                     ""
            }
            // determine  which post clicked
            val actionText = when(activity.actionType){
                 ActivityAction.CommentedOnPost ->
                    stringResource(id = R.string.your_post)
                 ActivityAction.LikedPost ->
                    stringResource(id = R.string.your_post)
                ActivityAction.FollowedYou ->
                    ""


            }
           Text( text = buildAnnotatedString {
                val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)
                withStyle(boldStyle){
                    append(activity.username)
                }
                append(" $fillerText ")
                withStyle(boldStyle){
                    append(actionText)

                }
            },
               fontSize = 12.sp,
               color = MaterialTheme.colors.onBackground

           )
            Text(
           text = activity.formattedTime,
                textAlign = TextAlign.Right,
                fontSize = 12.sp,
                color = MaterialTheme.colors.onBackground
            )

        }

    }

}