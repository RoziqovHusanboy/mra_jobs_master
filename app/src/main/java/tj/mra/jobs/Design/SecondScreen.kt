package tj.mra.jobs.Design


import android.annotation.SuppressLint
import androidx.annotation.ColorRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import tj.mra.jobs.R
import tj.mra.jobs.retrofit.MovieViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Second(navController: NavController,viewModel: MovieViewModel,movieName:String) {

    var currentItem = viewModel.getMovieByName(movieName.trim())

    var name = "Empty"
    if (currentItem?.name != null) {
        name = currentItem.name
    }
    var description = "Empty"
    if (currentItem?.desc != null) {
        description = currentItem.desc
    }

    Scaffold(topBar =
    {
        TopAppBar(

            title = {
                Text(text = name, fontSize = 25.sp, maxLines = 1,overflow = TextOverflow.Ellipsis)


            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            },
            backgroundColor = colorResource(id = R.color.background_topBar)
        )
    }) {

        var scroller = rememberScrollState()
        Column(modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize()) {
            Text(text = description, fontSize = 15.sp, modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .verticalScroll(scroller))


        }
    }
}





















