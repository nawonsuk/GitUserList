package com.mystory.gituserlist

import android.app.Application
import com.mystory.gituserlist.di.application.ApplicationComponent
import com.mystory.gituserlist.di.application.ApplicationModule
import com.mystory.gituserlist.di.application.DaggerApplicationComponent


class GitUserListApplication  : Application() {
    lateinit var component: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        inject()
    }
    fun inject() {
        component = DaggerApplicationComponent.builder().applicationModule(
                ApplicationModule(this)
        ).build()
        component.inject(this)
    }
}
