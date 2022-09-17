package com.hasan.retrofitapp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.hasan.retrofitapp.database.RetrofitDatabase
import kotlinx.coroutines.launch
import com.hasan.retrofitapp.model.Model

class DetailViewModel(application: Application):BaseViewModel(application) {

    val fieldLiveData = MutableLiveData<Model>()

    fun getDataFromRoom(uuid:Int){
       launch {
            val dao = RetrofitDatabase(getApplication()).retrofitDao()
            val field = dao.getField(uuid)
            fieldLiveData.value = field
       }
    }
}