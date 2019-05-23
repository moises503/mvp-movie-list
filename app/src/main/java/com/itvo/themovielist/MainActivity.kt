package com.itvo.themovielist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.itvo.themovielist.presenter.MoviePresenter
import com.itvo.themovielist.repository.Movie
import com.itvo.themovielist.view.MovieRecyclerViewAdapter
import com.itvo.themovielist.view.MovieView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MovieView{

    private lateinit var adapter: MovieRecyclerViewAdapter
    val presenter : MoviePresenter by inject { parametersOf(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MovieRecyclerViewAdapter(emptyList())
        lstMovies.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
        presenter.getMovieList()
    }

    override fun showError(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showMovieList(movies: List<Movie>) {
        adapter.updateDataSet(movies)
    }

}
