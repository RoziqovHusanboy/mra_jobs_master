package tj.mra.jobs.Design


import androidx.annotation.ColorRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import tj.mra.jobs.R
import tj.mra.jobs.retrofit.MovieViewModel

@Composable
fun Second(navController: NavController,viewModel: MovieViewModel,movieName:String,movieDesc:String) {

Scaffold(topBar =
            {TopAppBar(

     title = {
        Text(text = movieName, fontSize = 25.sp)


    },
    navigationIcon = {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
        }
    }
    ,
    backgroundColor = colorResource(id = R.color.background_topBar)
    )}) {

    var scroller = rememberScrollState()
    Column(modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxSize()) {
        Text(text = movieDesc, fontSize = 15.sp, modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(scroller))


    }
    }




        }
















