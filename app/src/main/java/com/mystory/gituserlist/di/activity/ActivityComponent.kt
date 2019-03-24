package com.mystory.gituserlist.di.activity

import com.mystory.gituserlist.di.scope.PerActivity
import com.mystory.gituserlist.presentation.activity.MainActivity
import dagger.Subcomponent

/**
 * FragmentComponent
 * @author wsseo
 * @since 2019. 3. 24
 **/
@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
  fun inject(mainActivity: MainActivity)
}
