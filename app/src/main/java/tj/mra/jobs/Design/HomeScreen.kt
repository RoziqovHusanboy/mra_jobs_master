@file:Suppress("UNNECESSARY_SAFE_CALL")

package tj.mra.jobs.Design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import tj.mra.jobs.*
import tj.mra.jobs.BottomNavItem.Head.title
import tj.mra.jobs.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home() {



    var navController = rememberNavController()

    var currentscreen = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

    Scaffold(
        modifier = Modifier,
        topBar = {

                TopAppBar(

                title =
                    {
                        if (currentscreen==BottomNavItem.Head.screen_route) {
                            Text(
                                text = "MRA Jobs",
                                fontSize = 28.sp,
                                modifier = Modifier.padding(start = 20.dp)
                            )

                        }
                         else if (currentscreen==Screens.Second_screen.route){
                            Text(
                                text = "Администратор",
                                fontSize = 28.sp,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        }
                        else if (currentscreen==BottomNavItem.Profile.screen_route){
                            Text(
                                text = "Profile",
                                fontSize = 28.sp,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        }



            },
                navigationIcon = {
                    if (currentscreen == Screens.Second_screen.route) {
                        IconButton(onClick = {
                            navController.navigate(BottomNavItem.Head.screen_route)
                        }) {
                            Icon(imageVector = Icons.Default.ArrowBack,
                                contentDescription = "")
                        }
                    }
                }, backgroundColor = colorResource(id = R.color.background_topBar)
            )
        },

            bottomBar = {
                if (currentscreen!=Screens.Second_screen.route) {
                    tj.mra.jobs.BottomNavigation(navController = navController)
                }

        }

    ) {

            Nav_Graph(navController = navController)

            }
        }





@Composable
fun Head(navController:NavController) {
    Column {

        LazyColumn() {
            items(items = list) {
                CardDemo(textTitle = it.title, textDesc = it.desc, onClick = {
                    navController.navigate(Screens.Second_screen.route)
                })
            }
        }

    }
}


@Composable
fun CardDemo(textTitle: String, textDesc: String, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(top = 16.dp, start = 25.dp, end = 25.dp, bottom = 16.dp)) {
        Column {
            Card(
                modifier = Modifier
                    .width(360.dp)
                    .height(226.dp),
                elevation = 2.dp,
                shape = RoundedCornerShape(10.dp),
                backgroundColor = colorResource(id = R.color.background_topBar)
            ) {
                Column {
                    Text(
                        text = "$textTitle",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp, start = 16.dp)
                    )

                    Text(
                        text = "$textDesc",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(
                            top = 16.dp,
                            start = 16.dp,
                            end = 16.dp,
                        ),
                    )
                    Button(
                        modifier = Modifier
                            .padding(start = 200.dp, top = 10.dp)
                            .width(140.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.button_color)),
                        onClick = {
                            onClick()
                        }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = ""
                        )
                        Text(text = "Подробное")
                    }
                }
            }
        }
    }
}






