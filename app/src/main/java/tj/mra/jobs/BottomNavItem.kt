package tj.mra.jobs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String, var icon: ImageVector, var screen_route:String)
{
    object Head:BottomNavItem(
        title = "Вакансия", icon = Icons.Default.Home, screen_route = "home")
    object Notifications:BottomNavItem(title = "Отклики", icon =Icons.Default.Notifications, screen_route = "notifications")
    object Profile:BottomNavItem(title = "Профиль", icon = Icons.Default.Person, screen_route = "profile")
}

