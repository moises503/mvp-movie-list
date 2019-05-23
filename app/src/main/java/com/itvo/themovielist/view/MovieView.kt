package com.itvo.themovielist.view

import com.itvo.themovielist.repository.Movie

interface MovieView {
    fun showError(message: String)
    fun showMovieList(movies : List<Movie>)
}