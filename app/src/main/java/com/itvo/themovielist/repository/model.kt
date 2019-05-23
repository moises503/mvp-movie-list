package com.itvo.themovielist.repository

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title")
    val name: String,
    @SerializedName("overview")
    val description : String,
    @SerializedName("poster_path")
    val photo : String)

data class PageEntity(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("results") val movies: List<Movie>)