package com.abdialidrus.popularmovies.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.use_case.MovieUseCases
import com.abdialidrus.popularmovies.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state

    init {
        savedStateHandle.get<Int>("movieId")?.let { movieId ->
            onEvent(MovieDetailEvent.LoadMovieDetail(movieId))
        }
    }

    fun onEvent(event: MovieDetailEvent) {
        when(event) {
            is MovieDetailEvent.LoadMovieDetail -> {
                loadMovieDetail(id = event.movieId)
            }
            is MovieDetailEvent.LikeDislikeMovie -> {
                likeOrDislikeMovie()
            }
        }
    }

    private fun loadMovieDetail(id: Int) {
        movieUseCases.getMovieDetail(id).onEach { resource ->
            when(resource) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    _state.value = state.value.copy(movie = resource.data)
                }
                is Resource.Error -> {

                }
            }
        }.launchIn(viewModelScope)
    }

    private fun likeOrDislikeMovie() {
        state.value.movie?.let {
            movieUseCases.likeOrDislikeMovie(it)
                .onEach { resource ->
                    when(resource) {
                        is Resource.Loading -> {

                        }
                        is Resource.Success -> {
                            _state.value = state.value.copy(movie = resource.data)
                        }
                        is Resource.Error -> {

                        }
                    }
                }
                .launchIn(viewModelScope)
        }
    }
}