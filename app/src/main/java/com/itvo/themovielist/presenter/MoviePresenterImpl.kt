package com.itvo.themovielist.presenter

import com.itvo.themovielist.repository.MovieRepository
import com.itvo.themovielist.view.MovieView

class MoviePresenterImpl(val view : MovieView, val repository : MovieRepository) : MoviePresenter{

    override fun getMovieList() {
        val response = repository.attemptGetMovieList().execute()

        if (response.isSuccessful) {
            view.showMovieList(response.body()!!.movies)
        } else {
            view.showError("No fue posible traer el listado de películas")
        }
    }
}