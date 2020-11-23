package com.peter.musicsearch.repository.data

import com.google.gson.annotations.SerializedName

data class HitItem(
    @SerializedName("index")
    val index : String,

    @SerializedName("type")
    val type: String,

    @SerializedName("result")
    val result: Result

)