package com.example.movieskotlin.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.movieskotlin.data.api.TheMovieDBInterface
import com.example.movieskotlin.data.repository.MovieDetailsNetworkDataSource
import com.example.movieskotlin.data.repository.NetworkState
import com.example.movieskotlin.data.vo.MoviesDetail
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MoviesDetail>
    {
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState()  : LiveData<NetworkState>
    {
        return movieDetailsNetworkDataSource.networkState
    }
}