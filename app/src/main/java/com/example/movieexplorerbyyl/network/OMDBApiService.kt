package com.example.movieexplorerbyyl.network
import com.example.movieexplorerbyyl.BuildConfig
import com.example.movieexplorerbyyl.data.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBApiService {
    @GET("/")
    suspend fun searchMovies(
        @Query("s") query: String,
        @Query("apikey") apiKey: String = BuildConfig.API_KEY
    ): Response<SearchResponse>
}
