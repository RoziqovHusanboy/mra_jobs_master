package tj.mra.jobs.retrofit

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch


class MovieViewModel:ViewModel() {



    private val _date = MutableLiveData<List<Movie>>()
    val date:LiveData<List<Movie>> = _date

    var erorMessage:String by mutableStateOf("")

    fun getMovieByName(name: String): Movie?{
        return date.value?.first(){it.name == name}
    }

    fun getMovieList():List<Movie>? {
        viewModelScope.launch {
            val apiService=ApiService.getInstance()
            try {
                val movieList = apiService.getMovies()
                _date.postValue(movieList)
            }
            catch (e:Exception){
                erorMessage = e.message.toString()
            }
        }
        return date.value
    }


}