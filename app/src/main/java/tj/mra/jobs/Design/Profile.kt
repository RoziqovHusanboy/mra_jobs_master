package tj.mra.jobs.Design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel



import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import tj.mra.jobs.Screens
import tj.mra.jobs.retrofit.Movie
import tj.mra.jobs.retrofit.MovieViewModel

@Composable
fun Profile(navController: NavController,viewModel: MovieViewModel) {
    var movies_data: List<Movie>? = viewModel.getMovieList()
    var movies: List<Movie> = listOf()
    if (movies_data != null){
        movies = movies_data
    }

    MovieList(movieList = movies,navController=navController)

}


@Composable
fun MovieList(movieList:List<Movie>,navController: NavController) {

        LazyColumn(modifier = Modifier.padding(bottom = 60.dp)){
            itemsIndexed(items = movieList){index, item ->
                Movie(
                    movie = item,
                    navController = navController,
                )
            }
        }

    }






@Composable
fun Movie(movie: Movie,navController: NavController,modifier: Modifier =Modifier){

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp)
            .clickable {
                navController.navigate(Screens.Second_screen.route + "/${movie.name}")
            },
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        androidx.compose.material.Surface {

            var painter  =rememberImagePainter(data = movie.imageUrl,
                builder ={
                    scale(coil.size.Scale.FILL)
                    placeholder(coil.compose.base.R.drawable.notification_action_background)
                    transformations(CircleCropTransformation())
                    crossfade(2000)
                })

            var painterState = painter.state
            Row (Modifier
                .padding(4.dp)
                .fillMaxSize()){
                Image(painter = painter,
                    contentDescription = movie.desc,
                    Modifier
                        .fillMaxHeight()
                        .weight(0.2f)

                )

              /* if (painterState is ImagePainter.State.Loading){
                    CircularProgressIndicator()
                } */

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = movie.name,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )

                    Text(text = movie.category,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray)
                            .padding(4.dp))

                    Text(
                        text = movie.desc,
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }

}
