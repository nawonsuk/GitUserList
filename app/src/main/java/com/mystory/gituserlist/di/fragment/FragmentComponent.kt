package com.mystory.gituserlist.di.fragment

import com.mystory.gituserlist.di.scope.PerFragment
import com.mystory.gituserlist.presentation.fragment.ApiFragment
import com.mystory.gituserlist.presentation.fragment.LocalFragment
import dagger.Subcomponent

/**
 * FragmentComponent
 * @author wsseo
 * @since 2019. 3. 24
 **/
@PerFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {
  fun inject_api(apiFragment: ApiFragment)
  fun inject_local(localFragment: LocalFragment)
}
