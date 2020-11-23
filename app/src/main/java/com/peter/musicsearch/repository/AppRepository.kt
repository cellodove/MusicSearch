package com.peter.musicsearch.repository

import com.peter.musicsearch.repository.data.ArtistData
import com.peter.musicsearch.repository.retrofit.RetrofitClient

class AppRepository {
    suspend fun searchArtist(artist : String) : ArtistData?{
        return RetrofitClient.searchArtist(artist).body()
    }
}