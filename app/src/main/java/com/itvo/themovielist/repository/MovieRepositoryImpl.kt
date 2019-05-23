package com.itvo.themovielist.repository

import retrofit2.Call
import retrofit2.Retrofit

class MovieRepositoryImpl(val retrofit: Retrofit) : MovieRepository{
    override fun attemptGetMovieList(): Call<PageEntity> {
        return retrofit.create(MovieEndPoint::class.java).getMovieList("API_KEY")
    }
}