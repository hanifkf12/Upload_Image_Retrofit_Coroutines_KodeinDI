package com.hanifkf12.retrofitupload.api


import com.hanifkf12.retrofitupload.model.UploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("upload")
    suspend fun uploadFile(@Part file : MultipartBody.Part, @Part("name") name : RequestBody) : Response<UploadResponse>
}