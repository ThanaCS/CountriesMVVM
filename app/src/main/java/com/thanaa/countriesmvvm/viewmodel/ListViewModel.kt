package com.thanaa.countriesmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thanaa.countriesmvvm.model.CountriesService
import com.thanaa.countriesmvvm.model.Country
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class ListViewModel:ViewModel() {
    private val countriesService = CountriesService()
    //disposable for cleaning the connection
    private val disposable = CompositeDisposable()
    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val  loading = MutableLiveData<Boolean>()

    fun refresh(){
        fetchCountries()
    }

    private fun fetchCountries(){
        loading.value = true
        disposable.add(
                //called on a background thread
                countriesService.getCountries()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object: DisposableSingleObserver<List<Country>>(){
                            override fun onSuccess(value: List<Country>) {
                                countries.value = value
                                countryLoadError.value = false
                                loading.value = false
                            }

                            override fun onError(e: Throwable) {
                                countryLoadError.value = true
                                loading.value = false
                            }

                        })

        )

    }
    override fun  onCleared(){
        disposable.clear()
    }

}