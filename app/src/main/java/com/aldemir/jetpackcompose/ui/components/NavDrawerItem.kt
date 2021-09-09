package com.aldemir.jetpackcompose.ui.components

import com.aldemir.jetpackcompose.R

sealed class NavDrawerItem(var route: String, var icon: Int, var title: String) {
    object Home : NavDrawerItem("home", R.drawable.ic_home, "Home")
    object Music : NavDrawerItem("music", R.drawable.ic_music, "Music")
    object Movies : NavDrawerItem("movies", R.drawable.ic_music, "Movies")
    object Books : NavDrawerItem("books", R.drawable.ic_music, "Books")
    object Profile : NavDrawerItem("profile", R.drawable.ic_profile, "Profile")
    object Settings : NavDrawerItem("settings", R.drawable.ic_settings, "Settings")
}
