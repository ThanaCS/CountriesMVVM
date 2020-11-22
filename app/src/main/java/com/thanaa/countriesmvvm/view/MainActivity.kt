package com.thanaa.countriesmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thanaa.countriesmvvm.R
import com.thanaa.countriesmvvm.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   lateinit var viewModel:ListViewModel
    var countriesAdapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        countriesList.apply {
        layoutManager = LinearLayoutManager(context)
        adapter = countriesAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {

       viewModel.countries.observe(this,Observer { countries ->
           countries?.let {
               countriesList.visibility = View.VISIBLE
               countriesAdapter.updateCounties(it)

           }
       })

        viewModel.countryLoadError.observe(this, Observer { isError -> isError?.let {
            list_error.visibility = if(it) View.VISIBLE else View.GONE
            } })

        viewModel.loading.observe(this, Observer { isLoading -> isLoading?.let{
            progressBar.visibility =  if(it) View.VISIBLE else View.GONE

            if(it){
                list_error.visibility =View.GONE
                countriesList.visibility = View.GONE
            }
        } })


    }
    }
