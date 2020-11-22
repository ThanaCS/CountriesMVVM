package com.thanaa.countriesmvvm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thanaa.countriesmvvm.R
import com.thanaa.countriesmvvm.model.Country
import com.thanaa.countriesmvvm.util.getProgressDrawable
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_country.view.*


class CountryListAdapter(var countries:ArrayList<Country>):RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCounties (newCountry:List<Country>){
        countries.clear()
        countries.addAll(newCountry)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CountryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country,parent,false))
    override fun getItemCount()= countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }


    class CountryViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val imageView = view.imageView
        private val capital = view.capital
    private val countryName =  view.name
        private val progressDrawable = getProgressDrawable(view.context)
        fun bind (country:Country){
            countryName.text = country.countryName
            capital.text = country.capital
            imageView.loadImage(country.flag, progressDrawable)        }

    }

}

fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable) {
val options = RequestOptions().placeholder(progressDrawable).error(R.mipmap.ic_launcher)
    Glide.with(this.context)
            .setDefaultRequestOptions(options)
            .load(uri)
            .into(this)
}
