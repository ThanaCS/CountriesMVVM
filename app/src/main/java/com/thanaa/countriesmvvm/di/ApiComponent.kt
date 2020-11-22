package com.thanaa.countriesmvvm.di

import com.thanaa.countriesmvvm.model.CountriesService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: CountriesService)
}