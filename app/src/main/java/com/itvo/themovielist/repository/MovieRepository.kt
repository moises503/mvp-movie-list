package com.itvo.themovielist.repository

import retrofit2.Call

interface MovieRepository {
    fun attemptGetMovieList() : Call<PageEntity>
}