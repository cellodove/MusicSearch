package com.peter.musicsearch.repository.retrofit

import com.peter.musicsearch.repository.data.ArtistData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val apiService: APIService = createRetrofit().create(APIService::class.java)


    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            //기본이되는 url
            .baseUrl("https://genius.p.rapidapi.com")
            //Json 형식의 파일을 바꿔준다.
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //코루틴사용 입출력 스레드이용하도록한다.
    suspend fun searchArtist(artist : String): Response<ArtistData> =
        withContext(Dispatchers.IO){
            return@withContext apiService.searchArtist(artist)
        }
}