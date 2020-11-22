package com.thanaa.countriesmvvm.model

import com.google.gson.Gson
import com.thanaa.countriesmvvm.di.DaggerApiComponent
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var  api:CountriesAPI
    init {
    DaggerApiComponent.create().inject(this)
    }

    fun getCountries(): Single<List<Country>> {
        return api.getCountries()
    }
}