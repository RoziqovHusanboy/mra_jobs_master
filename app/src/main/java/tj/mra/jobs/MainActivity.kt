package tj.mra.jobs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import tj.mra.jobs.Design.Home
import tj.mra.jobs.ui.theme.MRAJobsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MRAJobsTheme {
                Nav_Graph()
            }
        }
    }
}

