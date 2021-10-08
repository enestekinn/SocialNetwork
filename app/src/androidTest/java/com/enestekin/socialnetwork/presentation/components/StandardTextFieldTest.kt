package com.enestekin.socialnetwork.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.enestekin.socialnetwork.presentation.MainActivity
import com.enestekin.socialnetwork.presentation.login.LoginScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class StandardTextFieldTest {
    
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    
    @Before
    fun setUp(){
        composeTestRule.setContent {
        var text by remember {
            mutableStateOf("")
        }
            MaterialTheme {
                StandardTextField(
                    text = text,
                    onValueChange = {
                        text = it
                    },
                    maxLength = 5,
                    modifier = Modifier
                        .semantics {
                            testTag = "standard_text_field"
                        }
                )

            }
        }
    }
    
    @Test
    fun enterTooLongString_maxLengthNotExceeded(){
        composeTestRule.
        onNodeWithTag("standard_text_field")
            .performTextInput("123456")

        composeTestRule
            .onNodeWithTag("standard_text_field")
            .assertTextEquals("12345")
    }

}