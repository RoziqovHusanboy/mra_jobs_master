package tj.mra.jobs.retrofit

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel

import kotlinx.coroutines.launch



class MovieViewModel:ViewModel() {
    private val _date = MutableLiveData<List<Movie>>()
    val date:LiveData<List<Movie>> = _date

    init {
        fetchDate()
    }

    private fun fetchDate(){

    }

    var  movieListResponse:List<Movie> by mutableStateOf(listOf())
    var movie:Movie?=null
    var erorMessage:String by mutableStateOf("")

    init {

    }

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