package com.abdialidrus.popularmovies.presentation.favorite_movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.use_case.MovieUseCases
import com.abdialidrus.popularmovies.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoriteMoviesViewModel @Inject constructor(private val movieUseCases: MovieUseCases) :
    ViewModel(), DefaultLifecycleObserver {

    private val _state = mutableStateOf(FavoriteMoviesState())
    val state: State<FavoriteMoviesState> = _state

    private var getFavoriteMoviesJob: Job? = null

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        getFavoriteMovies()
    }

    fun onEvent(event: FavoriteMoviesEvent) {
        when (event) {
            is FavoriteMoviesEvent.LoadFavoriteMovies -> {
                getFavoriteMovies()
            }
            is FavoriteMoviesEvent.LikeDislikeMovie -> {
                likeOrDislikeMovie(event.movie)
            }
        }
    }

    private fun likeOrDislikeMovie(movie: Movie) {
        movieUseCases.likeOrDislikeMovie(movie)
            .onEach { resource ->
                when (resource) {
                    is Resource.Success -> {
                        getFavoriteMovies()
                    }
                    is Resource.Loading -> {

                    }
                    is Resource.Error -> {

                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun getFavoriteMovies() {
        getFavoriteMoviesJob?.cancel()
        getFavoriteMoviesJob = movieUseCases.getFavoriteMovies()
            .onEach { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.value = state.value.copy(isLoading = resource.isLoading)
                    }
                    is Resource.Success -> {
                        resource.data?.let {
                            _state.value = state.value.copy(movies = it)
                        }
                    }
                    else -> {
                        _state.value = state.value.copy(errorMessage = resource.message)
                    }
                }
            }.launchIn(viewModelScope)
    }
}