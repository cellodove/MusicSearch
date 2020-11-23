package com.peter.musicsearch.repository.data

import com.google.gson.annotations.SerializedName

data class ArtistData(
    @SerializedName("meta")
    val meta: Meta,

    @SerializedName("response")
    val response: ArtistResponse

)