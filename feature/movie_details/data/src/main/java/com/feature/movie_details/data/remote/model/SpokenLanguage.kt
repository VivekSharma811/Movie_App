package com.feature.movie_details.data.remote.model

import com.google.gson.annotations.SerializedName

data class SpokenLanguage(
    @SerializedName("english_name") val englishName: String,
    @SerializedName("iso_639_1") val iso: String,
    val name: String
)
