package tj.mra.jobs.retrofit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class MovieViewModel:ViewModel() {
    var  movieListResponse:List<Movie> by mutableStateOf(listOf())
    var movie:Movie?=null
    var erorMessage:String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService=ApiService.getInstance()
            try {
                val movieList = apiService.getMovies()
                movieListResponse = movieList
            }
            catch (e:Exception){
                erorMessage = e.message.toString()
            }
        }
    }


}