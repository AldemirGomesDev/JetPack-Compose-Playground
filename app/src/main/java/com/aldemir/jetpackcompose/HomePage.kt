package com.aldemir.jetpackcompose

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.aldemir.jetpackcompose.ui.components.Drawer
import com.aldemir.jetpackcompose.ui.components.TopBar
import com.aldemir.jetpackcompose.ui.theme.JetPackComposeTheme
import com.aldemir.jetpackcompose.ui.theme.Purple500

@Composable
fun HomePage() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(scope = scope, scaffoldState = scaffoldState)
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text("X")
            }
        },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        content = {
            Text("BodyContent")
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Purple500
            ) { Text("BottomAppBar") } }
    )
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    JetPackComposeTheme {
        HomePage()
    }
}