package com.app.taiye.countries.di

import com.app.taiye.countries.view.CountryListAdapter
import dagger.Module
import dagger.Provides


@Module
class CountryListAdapterModule {


    @Module
    companion object{

        @JvmStatic
        @Provides
        @PerActivity
        fun provideCountryListAdapter():CountryListAdapter{
            return  CountryListAdapter(arrayListOf())
        }
    }
}