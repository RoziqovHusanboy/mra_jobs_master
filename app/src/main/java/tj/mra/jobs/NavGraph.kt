package tj.mra.jobs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tj.mra.jobs.Design.*

@Composable
fun Nav_Graph(navController:NavHostController) {



    NavHost(navController = navController, startDestination = BottomNavItem.Head.screen_route){
        composable(BottomNavItem.Head.screen_route){
            Head(navController)
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


    }
}