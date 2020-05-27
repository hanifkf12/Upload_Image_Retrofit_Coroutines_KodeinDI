package com.hanifkf12.retrofitupload.presenter

import android.util.Log
import com.hanifkf12.retrofitupload.MainView
import com.hanifkf12.retrofitupload.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody

class MainPresenter (private val repository: MainRepository){
    private lateinit var view: MainView
    fun setView(view: MainView){
        this.view = view
    }

    fun uploadFile(name : RequestBody, file : MultipartBody.Part) = GlobalScope.launch(Dispatchers.Main) {
        view.showLoading()
        repository.uploadFile(name, file,{
            Log.d("RESPONSE", it?.file!!)
            view.hideLoading()
            view.showResponse(it.path!!)
        },{
            Log.e("ERROR", it)
            view.hideLoading()
            view.showError(it)
        })
    }

}