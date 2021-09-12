package com.aldemir.jetpackcompose.ui.components.bottomNavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aldemir.jetpackcompose.ui.theme.White


@Composable
fun BottomBar(navController: NavController){

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Music,
        BottomNavItem.Movies,
        BottomNavItem.Profile,
        BottomNavItem.Settings
    )

    BottomNavigation(
        elevation = 5.dp
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.map {
            BottomNavigationItem(
                icon= {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.title
                    )
                },
                label= {
                    Text(
                        text = it.title
                    )
                },
                selected = currentRoute == it.route,
                selectedContentColor= White,
                unselectedContentColor= White.copy(alpha = 0.4f),
                onClick = {
                    navController.navigate(it.route)
                }
            )
        }

    }
}