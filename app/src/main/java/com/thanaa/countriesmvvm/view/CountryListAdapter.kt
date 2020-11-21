package com.thanaa.countriesmvvm.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thanaa.countriesmvvm.model.Country

class CountryListAdapter(var countries:ArrayList<Country>):RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount()= countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }
    class CountryViewHolder(view: View):RecyclerView.ViewHolder(view){

        fun bind (country:Country){

        }

    }

}