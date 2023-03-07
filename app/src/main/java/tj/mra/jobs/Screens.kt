package tj.mra.jobs



sealed class Screens(val route: String) {
    object Second_screen : Screens("second_screen")

}

