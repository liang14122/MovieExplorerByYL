package com.example.movieexplorerbyyl

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieexplorerbyyl.data.Movie
import com.example.movieexplorerbyyl.network.RetrofitInstance
import kotlinx.coroutines.launch

import androidx.lifecycle.*
import com.example.movieexplorerbyyl.network.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val repository = MovieRepository()

    private val _movies = MutableLiveData<List<Movie>?>()
    val movies: MutableLiveData<List<Movie>?> get() = _movies

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun searchMovies(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val moviesResult = repository.searchMovies(query)
                if (moviesResult != null) {
                    _movies.value = moviesResult
                    _error.value = null
                } else {
                    _movies.value = listOf()
                    _error.value = "No results found."
                }
            } catch (e: Exception) {
                _error.value = e.localizedMessage ?: "An error occurred"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
