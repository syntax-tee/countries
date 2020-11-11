package com.app.taiye.countries.di

import com.app.taiye.countries.model.CountriesService
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component
interface AppComponent {


    fun getCountriesService(): CountriesService

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }
}