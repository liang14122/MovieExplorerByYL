package com.example.movieexplorerbyyl.network

import com.example.movieexplorerbyyl.data.Movie

class MovieRepository {
    suspend fun searchMovies(query: String): List<Movie>? {
        val response = RetrofitInstance.api.searchMovies(query = query)
        if (response.isSuccessful) {
            val searchResponse = response.body()
            if (searchResponse?.response.equals("True", ignoreCase = true)) {
                return searchResponse?.movies
            }
        }
        return null
    }
}
