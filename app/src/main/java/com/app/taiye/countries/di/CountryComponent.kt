package com.app.taiye.countries.di

import com.app.taiye.countries.view.MainActivity
import dagger.Component
import dagger.Subcomponent


@PerActivity
@Subcomponent( modules = [CountryListAdapterModule::class] )
interface CountryComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface  Builder {
        fun build(): CountryComponent
    }

}