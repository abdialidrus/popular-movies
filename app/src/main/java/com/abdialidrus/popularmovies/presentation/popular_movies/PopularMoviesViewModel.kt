package com.abdialidrus.popularmovies.presentation.popular_movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.use_case.MovieUseCases
import com.abdialidrus.popularmovies.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(private val movieUseCases: MovieUseCases) :
    ViewModel() {

    private val _state = mutableStateOf(PopularMoviesState())
    val state: State<PopularMoviesState> = _state

    val movies = movieUseCases.getPopularMovies().cachedIn(viewModelScope)

    fun onEvent(event: PopularMoviesEvent) {
        when (event) {
            is PopularMoviesEvent.LikeMovie -> {
                likeOrDislikeMovie(event.movie)
            }
            is PopularMoviesEvent.SearchMovie -> {

            }
        }
    }

    private fun likeOrDislikeMovie(movie: Movie) {
        movieUseCases.likeOrDislikeMovie(movie)
            .onEach {  }
            .launchIn(viewModelScope)
    }
}