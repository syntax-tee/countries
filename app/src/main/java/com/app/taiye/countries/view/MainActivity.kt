package com.app.taiye.countries.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.taiye.CountryApp
import com.app.taiye.countries.R
import com.app.taiye.countries.di.DaggerCountryComponent
import com.app.taiye.countries.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var viewModel: ListViewModel

    @Inject
    lateinit var  countriesAdapter:CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryComponent = DaggerCountryComponent.builder().appComponent(CountryApp.getAppComponent()).build()
        countryComponent.inject(this)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        countriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.countries.observe(this, Observer {countries ->
            countries?.let {
                countriesList.visibility = View.VISIBLE
                countriesAdapter.updateCountries(it) }
        })

        viewModel.countryLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if(it) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    list_error.visibility = View.GONE
                    countriesList.visibility = View.GONE
                }
            }
        })
    }
}
