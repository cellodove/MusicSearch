package com.peter.musicsearch.repository.retrofit

import com.peter.musicsearch.repository.data.ArtistData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService{
    @Headers(
        "x-rapidapi-host : genius.p.rapidapi.com",
        "x-rapidapi-key : b3ecde85b6msh09cfd41b0e828dep14ec1bjsnd3baafbc7a37"
    )

    //q뒤에 안드로이드에서 보낼 변수내용
    @GET("/search")
    suspend fun searchArtist(@Query("q") artist : String): Response<ArtistData>

}