package tj.mra.jobs.Design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel



import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import tj.mra.jobs.Screens
import tj.mra.jobs.retrofit.Movie
import tj.mra.jobs.retrofit.MovieViewModel

@Composable
fun Profile(navController: NavController,viewModel: MovieViewModel) {

    androidx.compose.material.Surface {

  MovieList(movieList = viewModel.movieListResponse,navController=navController)
        viewModel.getMovieList()

}
}

@Composable
fun MovieList(movieList:List<Movie>,navController: NavController) {

    LazyColumn(modifier = Modifier.padding(bottom = 60.dp)){
        itemsIndexed(items = movieList){index, item ->
            tj.mra.jobs.Design.Movie(movie = item,navController = navController)
        }
    }
}



@Composable
fun Movie(movie: Movie,navController: NavController){

    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp)
            .clickable {
           navController.navigate(Screens.Second_screen.route+"/${movie.name} / ${movie.desc}")
            },
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        androidx.compose.material.Surface {
            Row (Modifier
                .padding(4.dp)
                .fillMaxSize()){
                Image(painter = rememberImagePainter(data = movie.imageUrl,
                    builder ={
                        scale(coil.size.Scale.FILL)
                        placeholder(coil.compose.base.R.drawable.notification_action_background)
                        transformations(CircleCropTransformation())
                    }),
                    contentDescription = movie.desc,
                    Modifier
                        .fillMaxHeight()
                        .weight(0.2f)

                )

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
