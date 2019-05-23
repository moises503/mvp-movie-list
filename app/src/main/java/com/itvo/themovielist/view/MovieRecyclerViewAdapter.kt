package com.itvo.themovielist.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itvo.themovielist.R
import com.itvo.themovielist.repository.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieRecyclerViewAdapter(var movies : List<Movie>) : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.movie_item, p0, false))
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindMovie(movies[p1])
    }

    fun updateDataSet(movies : List<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }

    class ViewHolder(val item : View) : RecyclerView.ViewHolder(item){
        fun bindMovie(movie : Movie){
            item.txtDescription.text = movie.description
            item.txtTitle.text = movie.name
            Picasso.get().load(movie.photo).into(item.imgMovie)
        }
    }
}