package com.example.youtubeapi.app

import android.app.Application
import com.example.youtubeapi.di.adapterModule
import com.example.youtubeapi.di.networkModule
import com.example.youtubeapi.di.pagingSourceModule
import com.example.youtubeapi.di.repositoryModule
import com.example.youtubeapi.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule, pagingSourceModule, viewModelModule, adapterModule)
        }
    }
}