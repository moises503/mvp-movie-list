package com.itvo.themovielist.di

import com.itvo.themovielist.presenter.MoviePresenter
import com.itvo.themovielist.presenter.MoviePresenterImpl
import com.itvo.themovielist.repository.MovieRepository
import com.itvo.themovielist.repository.MovieRepositoryImpl
import com.itvo.themovielist.view.MovieView
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun providesRetrofit() : Retrofit {
    return Retrofit.Builder()
        .baseUrl("BASE_URL")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

val coreModule = module {
    single<Retrofit> { providesRetrofit() }
}

val movieModule  = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory<MoviePresenter> { (v : MovieView) ->
        MoviePresenterImpl(v, get())
    }
}