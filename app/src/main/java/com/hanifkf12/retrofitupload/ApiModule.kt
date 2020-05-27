package com.hanifkf12.retrofitupload

import com.hanifkf12.retrofitupload.api.ApiResource
import com.hanifkf12.retrofitupload.presenter.MainPresenter
import com.hanifkf12.retrofitupload.repository.MainRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val apiModule = Kodein.Module(name = "ApiModule"){
    bind() from singleton { ApiResource.create() }
    bind() from singleton { MainRepository(instance()) }
    bind() from provider { MainPresenter(instance()) }
}