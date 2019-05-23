package com.itvo.themovielist

import android.app.Application
import com.itvo.themovielist.di.coreModule
import com.itvo.themovielist.di.movieModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApp)
            modules(coreModule, movieModule)
        }
    }
}