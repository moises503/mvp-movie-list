package com.itvo.themovielist.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieEndPoint {
    @GET("movie/popular")
    fun getMovieList(@Query("api_key") apiKey: String) : Call<PageEntity>
}