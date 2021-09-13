package com.aldemir.jetpackcompose

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aldemir.jetpackcompose.ui.*
import com.aldemir.jetpackcompose.ui.components.Drawer.Drawer
import com.aldemir.jetpackcompose.ui.components.Drawer.NavDrawerItem
import com.aldemir.jetpackcompose.ui.components.TopBar
import com.aldemir.jetpackcompose.ui.components.bottomNavigation.BottomBar
import com.aldemir.jetpackcompose.ui.components.bottomNavigation.BottomNavItem
import com.aldemir.jetpackcompose.ui.theme.*
import android.view.WindowManager
import androidx.activity.viewModels
import com.aldemir.jetpackcompose.ui.pages.Dialogs
import com.aldemir.jetpackcompose.ui.pages.LoginScreen
import com.aldemir.jetpackcompose.ui.pages.ShowSnackBar


val list = listOf(
    "aldemir",
    "Eleonai",
    "Layssa",
    "Lorena",
    "aldemir",
    "Eleonai",
    "Layssa",
    "Lorena",
    "aldemir",
    "Eleonai",
    "Layssa",
    "Lorena",
    "aldemir",
    "Eleonai",
    "Layssa",
    "Lorena",
    "aldemir",
    "Eleonai",
    "Layssa",
    "Lorena",
    "aldemir",
    "Eleonai",
    "Layssa",
    "Lorena",
    "aldemir",
    "Eleonai",
    "Layssa",
    "Lorena",
    "aldemir",
    "Eleonai",
    "Layssa",
    "Lorena"
)

class MainActivity : ComponentActivity() {

    private val employeeViewModel: EmployeeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen(employeeViewModel, this)
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
//        onWindowFocusChanged()
    }

    private fun onWindowFocusChanged() {
        if (actionBar != null) {
            actionBar!!.hide()
        }
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
//                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
    fun showSystemUI() {
        if (actionBar != null) {
            actionBar!!.show()
        }
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
    }

}

@Composable
fun MainScreen(viewModel: EmployeeViewModel, context: Context) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(scope = scope, scaffoldState = scaffoldState)
        },
        floatingActionButtonPosition = FabPosition.End,
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
//                },
//                backgroundColor = Purple500,
//                contentColor = White,
//            ) {
//                Icon(Icons.Filled.Add, "")
//            }
//        },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
//        content = {
//            Text("BodyContent")
//        },
        bottomBar = {
            BottomBar(
                navController
            )
        }
    ) {
        Navigation(navController = navController, viewModel = viewModel, context = context)
    }
}

@Composable
fun Navigation(navController: NavHostController, viewModel: EmployeeViewModel, context: Context) {
    NavHost(navController, startDestination = NavDrawerItem.Home.route) {
        composable(NavDrawerItem.Home.route) {
            UserList(viewModel = viewModel, context = context)
        }
        composable(NavDrawerItem.Dialogs.route) {
            Dialogs()
        }
        composable(NavDrawerItem.Login.route) {
            LoginScreen()
        }
        composable(NavDrawerItem.Books.route) {
            BooksScreen()
        }
        composable(NavDrawerItem.Profile.route) {
            ShowSnackBar()
        }
        composable(NavDrawerItem.Settings.route) {
            SettingsScreen()
        }
        //Bottom Navigation
        composable(BottomNavItem.Home.route) {
            UserList(viewModel = viewModel, context = context)
        }
        composable(BottomNavItem.Dialogs.route) {
            Dialogs()
        }

        composable(BottomNavItem.Login.route) {
            LoginScreen()
        }

        composable(BottomNavItem.Profile.route) {
            ShowSnackBar()
        }

        composable(BottomNavItem.Settings.route) {
            SettingsScreen()
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeTheme {
//        MainScreen()
    }
}