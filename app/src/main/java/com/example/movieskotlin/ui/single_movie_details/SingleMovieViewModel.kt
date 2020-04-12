package com.example.movieskotlin.ui.single_movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieskotlin.data.repository.NetworkState
import com.example.movieskotlin.data.vo.MoviesDetail
import io.reactivex.disposables.CompositeDisposable

class SingleMovieViewModel(private val movieRepository: MovieDetailsRepository, movieId: Int): ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    val movieDetails: LiveData<MoviesDetail> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable, movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}