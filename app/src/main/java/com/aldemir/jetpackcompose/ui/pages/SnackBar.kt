package com.aldemir.jetpackcompose.ui.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.aldemir.jetpackcompose.ui.theme.Purple500
import kotlinx.coroutines.launch

@Composable
fun ShowSnackBar() {
    Scaffold(
        Modifier.padding(top = 20.dp)
    ) {
        val coroutineScope = rememberCoroutineScope()
        val snackBarHostState = SnackbarHostState()
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(
                            message = "Jetpack Compose Rocks",
                            actionLabel = "HIDE",
                            duration = SnackbarDuration.Long
                        )
                    }
                }
            ) {
                Text(text = "Show SnackBar")
            }
        }

        SnackBarHost(snackBarHostState)
    }
}

@Composable
fun SnackBarHost(snackBarHostState: SnackbarHostState) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp)
    ) {

        val (snackBarHostRef) = createRefs()
        SnackbarHost(
            modifier = Modifier
                .constrainAs(snackBarHostRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            hostState = snackBarHostState,
            snackbar = {
                Snackbar(
                    backgroundColor = Color.Black,
                    action = {
                        Text(
                            text = snackBarHostState.currentSnackbarData?.actionLabel ?: "",
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable {
                                    snackBarHostState.currentSnackbarData?.dismiss()
                                },
                            style = androidx.compose.ui.text.TextStyle(
                                fontWeight = FontWeight.Bold,
                                color = Purple500
                            )
                        )
                    }
                ) {
                    Text(text = snackBarHostState.currentSnackbarData?.message ?: "")
                }
            },

            )
    }
}