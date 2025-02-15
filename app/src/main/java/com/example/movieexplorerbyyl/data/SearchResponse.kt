package com.example.movieexplorerbyyl.data

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("Search") val movies: List<Movie>?,
    @SerializedName("totalResults") val totalResults: String?,
    @SerializedName("Response") val response: String
)
