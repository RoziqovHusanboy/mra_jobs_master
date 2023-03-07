package tj.mra.jobs

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import tj.mra.jobs.Design.*
import tj.mra.jobs.retrofit.Movie
import tj.mra.jobs.retrofit.MovieViewModel

@Composable
fun Nav_Graph(navController:NavHostController) {


    NavHost(navController = navController, startDestination = BottomNavItem.Head.screen_route){
        composable(BottomNavItem.Head.screen_route){
            Head(navController)
        }
        composable(Screens.Second_screen.route){
        Second(navController =navController)

        }
        composable(BottomNavItem.Profile.screen_route){
            Profile(navController)
        }
        composable(BottomNavItem.Notifications.screen_route){
            Notifications(navController)
        }


    }
}