package tj.mra.jobs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tj.mra.jobs.Design.*

@Composable
fun Nav_Graph() {

    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = BottomNavItem.Home.screen_route){
        composable(BottomNavItem.Home.screen_route){
            Home(navController)
        }
        composable("second_screen"){
            Second(navController)
        }
        composable(BottomNavItem.Profile.screen_route){
            Profile(navController)
        }
        composable(BottomNavItem.Notifications.screen_route){
            Notifications(navController)
        }
        composable(BottomNavItem.Home.screen_route){
            Home(navController)
        }
    }
}