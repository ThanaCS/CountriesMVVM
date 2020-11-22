package com.thanaa.countriesmvvm.model

import com.thanaa.countriesmvvm.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var api:CountriesAPI
    init {
    DaggerApiComponent.create().inject(this)
    }

    fun getCountries(): Single<List<Country>> {
        return api.getCountries()
    }
}