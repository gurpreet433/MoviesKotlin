package com.example.movieskotlin.data.api

import com.example.movieskotlin.data.vo.MoviesDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBInterface {


    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id")id : Int): Single<MoviesDetail>


}