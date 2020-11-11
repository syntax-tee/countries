package com.app.taiye

import android.app.Application
import com.app.taiye.countries.di.AppComponent
import com.app.taiye.countries.di.DaggerAppComponent

class CountryApp: Application() {


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }

    companion object{
        private lateinit var  appComponent: AppComponent

        fun getAppComponent():AppComponent{
            return  appComponent
        }
    }


}