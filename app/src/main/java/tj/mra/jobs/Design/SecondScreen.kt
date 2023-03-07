package tj.mra.jobs.Design

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import tj.mra.jobs.BottomNavItem
import tj.mra.jobs.R
import tj.mra.jobs.list
import tj.mra.jobs.retrofit.Movie
import tj.mra.jobs.retrofit.MovieViewModel

@Composable
fun Second(navController: NavController) {




    var scroller= rememberScrollState()
    Column(modifier = Modifier.padding(top = 16.dp)) {

        Text(text = "", fontSize = 15.sp, modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(scroller))
    }

    }






