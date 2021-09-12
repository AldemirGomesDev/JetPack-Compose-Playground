package com.aldemir.jetpackcompose.ui.components.bottomNavigation

import com.aldemir.jetpackcompose.R

sealed class BottomNavItem(var route: String, var icon: Int, var title: String) {
    object Home : BottomNavItem("home", R.drawable.ic_home, "Home")
    object Music : BottomNavItem("music", R.drawable.ic_music, "Music")
    object Movies : BottomNavItem("movies", R.drawable.ic_movie, "Movies")
    object Profile : BottomNavItem("profile", R.drawable.ic_profile, "Profile")
    object Settings : BottomNavItem("settings", R.drawable.ic_settings, "Settings")
}
