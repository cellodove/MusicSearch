package com.peter.musicsearch.repository.data

import com.google.gson.annotations.SerializedName

data class Result(

    @SerializedName("id")
    val id : Int,

    @SerializedName("full_title")
    val full_title : String,

    @SerializedName("title")
    val title : String,

    @SerializedName("song_art_image_thumbnail_url")
    val song_art_image_thumbnail_url : String,

    @SerializedName("song_art_image_url")
    val song_art_image_url : String



)