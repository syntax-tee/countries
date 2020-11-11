package com.app.taiye.countries.di

import com.app.taiye.countries.view.MainActivity
import dagger.Component


@PerActivity
@Component( dependencies =  [AppComponent::class], modules = [CountryListAdapterModule::class] )
interface CountryComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface  Builder {

        fun build(): CountryComponent

        fun  appComponent(appComponent: AppComponent): Builder
    }

}