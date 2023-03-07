package tj.mra.jobs.Design

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import tj.mra.jobs.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Notifications(navController: NavController) {
    var scroller = rememberScrollState()
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutine = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetShape = RoundedCornerShape(30.dp),
        sheetContent = {
            Column {
                androidx.compose.material.Text(
                    text = "Администратор",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 50.dp, top = 8.dp, bottom = 10.dp)
                )
                androidx.compose.material.Text(
                    text = "В Алиф Академию требуется администратор на полный рабочий день, который возьмёт на себя административные задачи и станет частью нашей дружной команды.\n" +
                            "Обязанности:\n" +
                            "— Приём гостей и клиентов;\n" +
                            "— Консультирование гостей и клиентов;\n" +
                            "— Контроль чистоты и порядка в офисе;\n" +
                            "— Участие в организации корпоративных мероприятий;\n" +
                            "— Обеспечение операционной работы офиса (заказ канцтоваров, расходных материалов);\n" +
                            "— Соблюдение корпоративной культуры.\n" +
                            "Требования:— Умение работать в команде и правильно коммуницировать с людьми;\n" +
                            "― Уверенный пользователь ПК, Microsoft Office (Excel and Word);\n" +
                            "— Навыки работы с оргтехникой;— Стремление к профессиональному и личностному росту;\n" +
                            "— Умение и желание работать в режиме многозадачности;— Организаторские навыки;\n" +
                            "― Знание таджикского и русского языков;\n" +
                            "― Работа в офисе.\n" +
                            "Мы ценим:\n" +
                            "— Честность;\n" +
                            "— Скромность;\n" +
                            "— Пунктуальность;\n" +
                            "— Внимательность;\n" +
                            "— Усердность в работе.\n" +
                            "Предлагаем:\n" +
                            "— Работа в режиме 5/2;\n" +
                            "— Конкурентную оплату труда;\n" +
                            "— Обучение в процессе работы;\n" +
                            "— Карьерный рост;\n" +
                            "— Дружелюбный коллектив и развитие вместе с компанией.\n" +
                            "Рассматриваются кандидатуры тех, кто отправил резюме, написал сопроводительное письмо и сдавшие тесты.\n" +
                            "Удачи ",
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 60.dp)
                        .verticalScroll(scroller),
                )

            }

        },
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background_topBar))

    ) {
        Button(onClick = {
            coroutine.launch {
                sheetState.bottomSheetState.expand()
            }
        }) {
            Text(text = "Click")
        }
        
    }
}

