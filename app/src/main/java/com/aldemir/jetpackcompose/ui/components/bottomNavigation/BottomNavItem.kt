package com.aldemir.jetpackcompose.ui.components.bottomNavigation

import com.aldemir.jetpackcompose.R

sealed class BottomNavItem(var route: String, var icon: Int, var title: String) {
    object Home : BottomNavItem("home", R.drawable.ic_home, "Home")
    object Dialogs : BottomNavItem("dialogs", R.drawable.ic_music, "Dialogs")
    object Login : BottomNavItem("login", R.drawable.ic_movie, "Login")
    object Profile : BottomNavItem("profile", R.drawable.ic_profile, "Profile")
    object Settings : BottomNavItem("settings", R.drawable.ic_settings, "Settings")
}
