package com.app.taiye.countries.model

import android.util.Log
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CountriesService @Inject constructor() {
    private val BASE_URL = "https://raw.githubusercontent.com"


    init {
        Log.d(TAG, ": CountriesService is added to dependency graph ")
    }

    companion object{
        private const val TAG ="DaggerLog"
    }


    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CountriesApi::class.java)

    fun getCountries(): Single<List<Country>> {
        return api.getCountries()
    }
}