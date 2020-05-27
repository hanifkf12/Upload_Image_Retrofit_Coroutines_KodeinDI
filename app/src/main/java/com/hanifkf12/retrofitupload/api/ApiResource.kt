package com.hanifkf12.retrofitupload.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiResource {
//    private fun createInterceptor() : Interceptor {
//        return Interceptor { chain ->
//            val builder = chain.request().newBuilder()
//            builder.header("Authorization", "Bearer token")
//            return@Interceptor chain.proceed(builder.build())
//        }
//    }

    fun create() : ApiService{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(logging)
        val client = clientBuilder.build()

        val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl("https://still-temple-51886.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit.create(ApiService::class.java)
    }
}