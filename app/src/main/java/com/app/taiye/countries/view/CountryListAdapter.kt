package com.app.taiye.countries.view

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.taiye.countries.R
import com.app.taiye.countries.di.PerActivity
import com.app.taiye.countries.model.Country
import com.app.taiye.countries.util.getProgressDrawable
import com.app.taiye.countries.util.loadImage
import kotlinx.android.synthetic.main.item_country.view.*
import javax.inject.Inject

@PerActivity
class CountryListAdapter @Inject constructor(var countries: ArrayList<Country>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {


    init {
        Log.d(TAG, ": Countrylist adapter is added to dependency graph ")
    }

    companion object{
        private const val TAG ="DaggerLog"
    }


    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
    )

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageView = view.imageView
        private val countryName = view.name
        private val countryCapital = view.capital
        private val progressDrawable = getProgressDrawable(view.context)

        fun bind(country: Country) {
            countryName.text = country.countryName
            countryCapital.text = country.capital
            imageView.loadImage(country.flag, progressDrawable)
        }
    }
}