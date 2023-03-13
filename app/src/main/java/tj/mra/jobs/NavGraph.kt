package tj.mra.jobs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tj.mra.jobs.Design.*
import tj.mra.jobs.retrofit.MovieViewModel

@Composable
fun Nav_Graph(navController:NavHostController,viewModel: MovieViewModel) {


    NavHost(navController = navController, startDestination = BottomNavItem.Head.screen_route){
            composable(BottomNavItem.Head.screen_route){
                Head(navController =navController,viewModel = viewModel)
            }

        composable(Screens.Second_screen.route + "/{name}"){
        Second(navController =navController,viewModel = viewModel,
            movieName = it.arguments?.getString("name")?:"name")
        }
        composable(BottomNavItem.Profile.screen_route){
            Profile(navController,viewModel = viewModel)
        }
        composable(BottomNavItem.Notifications.screen_route){
            Notifications(navController)
        }
        composable("add"){
            Add(navController=navController)
        }


    }
}