package com.hanifkf12.retrofitupload.repository

import com.hanifkf12.retrofitupload.api.ApiService
import com.hanifkf12.retrofitupload.model.UploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody

class MainRepository(private val apiService: ApiService) {

    suspend fun uploadFile(
        name: RequestBody,
        requestFile: MultipartBody.Part,
        onResult: (UploadResponse?) -> Unit,
        onError : (String) ->Unit
    ) {
        val response = apiService.uploadFile(requestFile, name)
        if(response.isSuccessful){
            onResult(response.body())
        }else{
            onError(response.message())
        }
    }
}