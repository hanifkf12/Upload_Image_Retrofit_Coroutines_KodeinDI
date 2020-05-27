package com.hanifkf12.retrofitupload

import android.app.Application
import com.hanifkf12.retrofitupload.api.ApiResource
import com.hanifkf12.retrofitupload.presenter.MainPresenter
import com.hanifkf12.retrofitupload.repository.MainRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class BaseApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@BaseApplication))
        import(apiModule)
    }

}