package tj.mra.jobs.Design

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import tj.mra.jobs.list

@Composable
fun Second(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()){
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }

    }
}

