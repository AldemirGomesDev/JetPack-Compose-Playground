package com.aldemir.jetpackcompose

sealed class NavDrawerItem(var route: String, var icon: Int, var title: String) {
    object Home : NavDrawerItem("home", R.drawable.ic_home, "Home")
    object Music : NavDrawerItem("music", R.drawable.ic_music, "Music")
    object Profile : NavDrawerItem("profile", R.drawable.ic_profile, "Profile")
    object Settings : NavDrawerItem("settings", R.drawable.ic_settings, "Settings")
}
