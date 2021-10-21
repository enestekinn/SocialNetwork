package com.enestekin.socialnetwork.presentation.create_post

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.presentation.components.StandardTextField
import com.enestekin.socialnetwork.presentation.components.StandardToolbar
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceLarge
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceMedium
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceSmall
import com.enestekin.socialnetwork.presentation.util.Screen
import com.enestekin.socialnetwork.presentation.util.states.StandardTextFieldState

@Composable
fun CreatePostScreen(
    navController: NavController,
    viewModel: CreatePostViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.create_a_new_post),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },

        )
        Spacer(modifier = Modifier.height(SpaceMedium))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceLarge)

        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onBackground,
                        shape = MaterialTheme.shapes.medium
                    )
                    .clickable {

                    },
                contentAlignment = Alignment.Center

            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.choose_image),
                    tint = MaterialTheme.colors.onBackground
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))

            StandardTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                text = viewModel.descriptionState.value.text,
                hint = stringResource(id = R.string.description),
                error = viewModel.descriptionState.value.error,
                singleLine = false,
                maxLines = 5,
                leadingIcon = Icons.Default.Description,
                onValueChange = {
                    viewModel.setDescriptionState(
                        StandardTextFieldState(text = it)
                    )
                }
            )
            Spacer(modifier = Modifier.height(SpaceLarge))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = R.string.post),
                    color = MaterialTheme.colors.onPrimary
                )
                Spacer(modifier = Modifier.width(SpaceSmall))

                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription  =  null)
            }

        }
    }


}