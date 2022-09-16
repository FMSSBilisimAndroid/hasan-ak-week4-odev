package com.hasan.retrofitapp.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasan.retrofitapp.model.Model
import com.hasan.retrofitapp.service.RetrofitAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class FeedViewModel : ViewModel() {

    private val retrofitAPIService = RetrofitAPIService()
    private val disposable = CompositeDisposable()

    val fieldsMars = MutableLiveData<List<Model>>()

   fun getDataFromApi() {

        disposable.add(
            retrofitAPIService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Model>>() {
                    override fun onSuccess(t: List<Model>) {
                        fieldsMars.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }
}