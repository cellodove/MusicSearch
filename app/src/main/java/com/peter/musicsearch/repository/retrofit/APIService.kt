package com.peter.musicsearch.repository.retrofit

import com.peter.musicsearch.repository.data.ArtistData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService{
/*    @Headers(
        "x-rapidapi-host : genius.p.rapidapi.com",
        "x-rapidapi-key : c0e7932c06mshd5ce79e2d2e82b6p174f53jsn5780820133a8"
    )

    //q뒤에 안드로이드에서 보낼 변수내용
    @GET("/search")
    suspend fun searchArtist(@Query("q") artist : String): Response<ArtistData>*/

    @Headers(
        "x-rapidapi-host: genius.p.rapidapi.com",
        "x-rapidapi-key: c0e7932c06mshd5ce79e2d2e82b6p174f53jsn5780820133a8"
    )
    @GET("/search")
    suspend fun searchArtist(@Query("q") artist: String): Response<ArtistData>

}