package com.thanaa.countriesmvvm.di

import com.thanaa.countriesmvvm.model.CountriesService
import com.thanaa.countriesmvvm.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: CountriesService)
    fun inject(viewModel: ListViewModel)
}