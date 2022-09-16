package com.hasan.retrofitapp.service




import com.hasan.retrofitapp.model.Model
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitAPI {

    //https://mars.udacity.com/realestate
    //BASE_URL -> https://mars.udacity.com/
    //EXT -> realestate

    @GET("realestate")
    fun getFieldsMars():Single<List<Model>>
}