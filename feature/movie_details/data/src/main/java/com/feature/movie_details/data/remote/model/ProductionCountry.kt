package com.feature.movie_details.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProductionCountry(
    @SerializedName("iso_3166_1") val iso: String,
    val name: String
)
