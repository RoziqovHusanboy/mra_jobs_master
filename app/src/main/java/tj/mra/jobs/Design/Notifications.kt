package tj.mra.jobs.Design

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import tj.mra.jobs.R
import tj.mra.jobs.room.Item
import tj.mra.jobs.room.ItemViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Notifications(navController: NavController,itemViewModel: ItemViewModel = viewModel()) {

    Scaffold(
        modifier = Modifier.padding(bottom = 60.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("add")
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "", tint = Color.White)
            }

        }
    ) {
        val items by itemViewModel.items.observeAsState(mutableListOf())
        LazyColumn {
            items(items) { item ->
                Card(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    elevation = 5.dp) {

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Name: ${item.name}", fontSize = 20.sp)
                        Text(text = "Price: ${item.price}", fontSize = 20.sp)   

                            
                        Text(
                            buildAnnotatedString {
                                append("Quantity: ")
                                withStyle(style = SpanStyle(color = colorResource(id = R.color.teal_700), fontWeight = FontWeight.Bold)) {
                                    append("${item.quantity}")
                                }

                        }
                        , fontSize = 22.sp
                        )

                    }


                        IconButton(
                            modifier = Modifier.padding(top = 59.dp,start = 130.dp),
                            onClick = {
                                item.quantity += 1
                                itemViewModel.update(item)
                            }) {
                            Text(text = "+", fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        IconButton(
                            modifier = Modifier.padding(top = 59.dp,start = 250.dp),
                            onClick = {
                                item.quantity -= 1.0
                                itemViewModel.update(item)
                            }) {
                            Text(text = "-", fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                            )

                    } 
                }
            }
        }

    }

}

