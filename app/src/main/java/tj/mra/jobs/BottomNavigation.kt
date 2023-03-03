package tj.mra.jobs

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(navController: NavController) {
        var items = listOf(
            BottomNavItem.Head,
            BottomNavItem.Notifications,
            BottomNavItem.Profile
        )
        androidx.compose.material.BottomNavigation(
            backgroundColor = colorResource(id = R.color.background_bottom),
            contentColor = Color.Black
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute=navBackStackEntry?.destination?.route
            items.forEach{item->
                BottomNavigationItem(
                    icon = { Icon(imageVector = item.icon, contentDescription = "")},
                    label = { Text(text = item.title)},
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Black.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute==item.screen_route,
                    onClick = {
                        navController.navigate(item.screen_route){
                        navController.graph.startDestinationRoute?.let { screen_route->
                            popUpTo(screen_route){
                                saveState = true
                            }
                        }

                        launchSingleTop=true
                        restoreState=true
                        }

                    }
                )

            }
        }
}