package com.hasan.retrofitapp.service


import com.hasan.retrofitapp.model.Model
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitAPIService {

    //https://mars.udacity.com/realestate
    //BASE_URL -> https://mars.udacity.com/

    private val BASE_URL = "https://mars.udacity.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(RetrofitAPI::class.java)

    fun getData() : Single<List<Model>> {
        return api.getFieldsMars()
    }
}