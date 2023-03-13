package tj.mra.jobs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.HiltAndroidApp
import tj.mra.jobs.Design.Home
import tj.mra.jobs.retrofit.MovieViewModel
import tj.mra.jobs.ui.theme.MRAJobsTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MRAJobsTheme {

               Home()
            }
        }
    }

}

