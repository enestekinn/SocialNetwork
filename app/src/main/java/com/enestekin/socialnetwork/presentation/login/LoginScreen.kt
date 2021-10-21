package com.enestekin.socialnetwork.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.presentation.MainFeedScreen
import com.enestekin.socialnetwork.presentation.components.StandardTextField
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceLarge
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceMedium
import com.enestekin.socialnetwork.presentation.util.Screen

@Composable
fun LoginScreen(
    navController: NavController,
viewModel: LoginViewModel = hiltViewModel() //this is how  viewModel initialize by dagger-hilt
) {

Box(
    modifier = Modifier
        .fillMaxSize()
        .padding(
            start = SpaceLarge,
            end = SpaceLarge,
            top = SpaceLarge,
            bottom = 50.dp
        )
        ){

    Column(
        modifier = Modifier
        .fillMaxSize()
        .align(Alignment.Center),
        verticalArrangement = Arrangement.Center,

    ) {
        Text(
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.h1
        )

        Spacer(modifier = Modifier.height(SpaceMedium))
        StandardTextField(
            text =viewModel.usernameText.value ,
            onValueChange ={
            viewModel.setUsernameText(it)
        },
            keyboardType = KeyboardType.Email,
            error = viewModel.usernameError.value,
            hint = stringResource(id = R.string.login_hint))


        Spacer(modifier = Modifier.height(SpaceMedium))
        StandardTextField(
            text =viewModel.passwordText.value ,
            onValueChange ={
            viewModel.setPasswordText(it)
        },
            hint = stringResource(id = R.string.password_hint),
            keyboardType = KeyboardType.Password,
            error = viewModel.passwordError.value,
            showPasswordToggle = viewModel.showPassword.value,
            onPasswordToggleClick = {
                viewModel.setShowPassword(it)
            }
        )
        Spacer(modifier = Modifier.height(SpaceMedium))

        Button(
            onClick = {
                      navController.navigate(Screen.MainFeedScreen.route)
            },
            modifier = Modifier
                .align(Alignment.End),
        ) {
            Text(
                text = stringResource(id = R.string.login),
                color = MaterialTheme.colors.onPrimary

            )
        }

    }
    //  use buildAnnotatedString for green color
    Text(
        text = buildAnnotatedString {
            append(stringResource(id = R.string.dont_have_an_account_yet))
            append(" ")
          val signUpText = stringResource(id = R.string.sign_up)

                  withStyle(
                style = SpanStyle(
                color = MaterialTheme.colors.primary
                    )
            ){
              append(signUpText)
          }
            },
        style = MaterialTheme.typography.body1,
        modifier = Modifier
            .align(Alignment.BottomCenter)
// making whole text clickable
            .clickable {
                navController.navigate(
                    Screen.RegisterScreen.route
                )
            }


         )
}

}



