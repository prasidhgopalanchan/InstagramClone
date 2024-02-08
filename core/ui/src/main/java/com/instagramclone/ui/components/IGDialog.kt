package com.instagramclone.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.instagramclone.util.constants.Utils

@Composable
fun IGDialog(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String = "",
    showDialog: Boolean,
    showBlueButton: Boolean,
    showWhiteButton: Boolean = true,
    button1Text: String,
    button2Text: String = "",
    onBlueClick: () -> Unit,
    onWhiteClick: () -> Unit,
) {
    AnimatedVisibility(
        visible = showDialog,
        enter = fadeIn(animationSpec = tween(300)),
        exit = fadeOut(animationSpec = tween(300))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Utils.IgBlack.copy(alpha = 0.6f)),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentHeight(Alignment.CenterVertically)
                    .fillMaxWidth(0.66f),
                shape = RoundedCornerShape(20.dp),
                color = Utils.IgOffBlack
            ) {
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = modifier.padding(start = 25.dp, end = 25.dp, top = 25.dp),
                        text = title,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    )
                    if (subTitle != "") {
                        Text(
                            modifier = modifier.padding(top = 10.dp, start = 25.dp, end = 25.dp),
                            text = subTitle,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White.copy(alpha = 0.6f),
                                textAlign = TextAlign.Center
                            )
                        )
                    }


                    if (showBlueButton) {
                        Divider(
                            modifier = Modifier.padding(top = 30.dp),
                            thickness = 0.5.dp,
                            color = Color.White.copy(alpha = 0.1f)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(onClick = onBlueClick),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Text(
                                modifier = Modifier.padding(vertical = 15.dp),
                                text = button2Text,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Utils.IgBlue,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }

                    if (showWhiteButton) {
                        Divider(
                            modifier = if (!showBlueButton) Modifier.padding(top = 30.dp) else Modifier,
                            thickness = 0.5.dp,
                            color = Color.White.copy(alpha = 0.1f)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(onClick = onWhiteClick),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Text(
                                modifier = Modifier.padding(vertical = 15.dp),
                                text = button1Text,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(apiLevel = 33)
@Composable
fun IGDialogPreview() {
    IGDialog(
        title = "Incorrect username or password",
        subTitle = "The username or password you entered doesn't appear to belong to an account. Please check your username or password and try again.",
        showDialog = true,
        showBlueButton = true,
        showWhiteButton = true,
        button1Text = "Sign Up",
        button2Text = "Try Again",
        onBlueClick = {  },
        onWhiteClick = {  }
    )
}