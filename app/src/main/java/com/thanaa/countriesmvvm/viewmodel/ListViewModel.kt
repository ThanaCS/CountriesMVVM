package com.thanaa.countriesmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thanaa.countriesmvvm.model.Country


class ListViewModel:ViewModel() {

    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val  loading = MutableLiveData<Boolean>()

    fun refresh(){
        fetchCountries()
    }

    private fun fetchCountries(){
        var mockData:List<Country> = listOf(Country("Saudi"),Country("US"),Country("Germany"))
        countryLoadError.value = false
        loading.value =false
        countries.value = mockData
    }


}