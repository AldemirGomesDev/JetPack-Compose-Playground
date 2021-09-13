package com.aldemir.jetpackcompose.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.aldemir.jetpackcompose.ui.theme.Purple500

@Composable
fun Dialogs() {
    Scaffold(
        Modifier.padding(top = 20.dp)
    ) {
        val openDialog = remember { mutableStateOf(false) }
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    openDialog.value = true
                }
            ) {
                Text(text = "Show Alert Dialog")
            }
            AlertDialogComponent(openDialog.value) {
                openDialog.value = false
            }
        }
    }
}


@Composable
fun AlertDialogComponent(showDialog: Boolean, dismissDialog: () -> Unit) {

    if (showDialog) {

        AlertDialog(

            onDismissRequest = { dismissDialog() },

            title = {
                Text(
                    text = "Jetpack Compose",
                    color = Purple500,
                    fontWeight = FontWeight.Bold
                )
            },

            text = {
                Text(
                    "Hello! This is Alert Dialog from compose",
                    color = Purple500
                )
            },

            confirmButton = {
                TextButton(
                    onClick = {
                        dismissDialog()
                    }
                ) {
                    Text("Sim", color = Purple500)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        dismissDialog()
                    }
                ) {
                    Text("Não", color = Purple500)
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.Black,
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ),
        )
    }
}