package com.hanifkf12.retrofitupload

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showResponse(data : String)
    fun showError(error : String)
}