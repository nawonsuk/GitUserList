package com.mystory.gituserlist.di.application

import com.mystory.gituserlist.GitUserListApplication
import com.mystory.gituserlist.di.activity.ActivityComponent
import com.mystory.gituserlist.di.activity.ActivityModule
import com.mystory.gituserlist.di.net.NetModule
import com.mystory.gituserlist.di.net.RepositoryModule
import com.mystory.gituserlist.di.net.UseCasesModule
import com.mystory.gituserlist.di.fragment.FragmentComponent
import com.mystory.gituserlist.di.fragment.FragmentModule
import dagger.Component
import javax.inject.Singleton

/**
 * ApplicationComponent
 * @author wsseo
 * @since 2019. 3. 24
 **/
@Singleton
@Component(modules = arrayOf(
    ApplicationModule::class,
    NetModule::class,
    RepositoryModule::class,
    UseCasesModule::class
))
interface ApplicationComponent {
  fun inject(activity: GitUserListApplication)
  fun activity_plus(amodule: ActivityModule): ActivityComponent
  fun fragment_plus(fmodule: FragmentModule): FragmentComponent
}
