package tj.mra.jobs.retrofit

import android.content.Context
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("movielist.json")
    suspend fun getMovies():List<Movie>

    companion object{
        var apiService:ApiService?=null
        fun getInstance():ApiService{
            if (apiService==null){
                apiService=Retrofit.Builder().baseUrl("https://www.howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }


    }

}