package com.aldemir.jetpackcompose.ui.components.Drawer

import com.aldemir.jetpackcompose.R

sealed class NavDrawerItem(var route: String, var icon: Int, var title: String) {
    object Home : NavDrawerItem("home", R.drawable.ic_home, "Home")
    object Dialogs : NavDrawerItem("dialogs", R.drawable.ic_music, "Dialogs")
    object Login : NavDrawerItem("login", R.drawable.ic_movie, "Login")
    object Books : NavDrawerItem("books", R.drawable.ic_music, "Books")
    object Profile : NavDrawerItem("profile", R.drawable.ic_profile, "Profile")
    object Settings : NavDrawerItem("settings", R.drawable.ic_settings, "Settings")
    object Swipe : NavDrawerItem("Swipe", R.drawable.ic_settings, "Swipe")
}
