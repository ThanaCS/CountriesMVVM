package com.thanaa.countriesmvvm.model

import io.reactivex.Single
import retrofit2.http.GET

interface CountriesAPI {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries():Single<List<Country>>//single is an observable that emits one variable then closes it

}