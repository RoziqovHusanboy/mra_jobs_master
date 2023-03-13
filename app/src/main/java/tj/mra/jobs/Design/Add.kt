package tj.mra.jobs.Design

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import tj.mra.jobs.BottomNavItem
import tj.mra.jobs.room.Item
import tj.mra.jobs.room.ItemViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Add(navController: NavController,itemViewModel: ItemViewModel = viewModel()) {
        var name by remember { mutableStateOf("")}
        var price by remember { mutableStateOf("")}
        var quantity by remember { mutableStateOf("")}


    Scaffold {
        Column(modifier = Modifier.fillMaxSize().padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Add new note",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp))

            OutlinedTextField(value = name,
                onValueChange = {name = it},
                label = { Text(text = "Note name")},
                isError = name.isEmpty()
            )
            OutlinedTextField(value = price,
                onValueChange = {price = it},
                label = { Text(text = "Note price")},
                        isError = price.isEmpty()
            )
            OutlinedTextField(value = quantity,
                onValueChange = {quantity = it},
                label = { Text(text = "Note quantity") }
            , keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
            ),
                        isError = quantity.isEmpty()
            )




            Button(
                modifier = Modifier.padding(top = 16.dp),
                onClick = {

                    itemViewModel.addItem(item = Item( name = name, price = price, quantity = quantity.toDouble()
                    ))


                navController.navigate(BottomNavItem.Notifications.screen_route)
            }) {
                Text(text = "Add note")
            }
        }

    }

}