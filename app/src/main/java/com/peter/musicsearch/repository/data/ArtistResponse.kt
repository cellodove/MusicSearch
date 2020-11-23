package com.peter.musicsearch.repository.data

import com.google.gson.annotations.SerializedName

data class ArtistResponse(
    @SerializedName("hits")
    val hitsList: List<HitItem>

)