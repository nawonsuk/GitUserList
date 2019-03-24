package com.mystory.gituserlist.di.fragment
import com.mystory.gituserlist.di.scope.PerFragment
import com.mystory.gituserlist.presentation.fragment.BaseFragment
import dagger.Module
import dagger.Provides

/**
 * FragmentModule
 * @author wsseo
 * @since 2019. 3. 24
 **/
@Module
class FragmentModule(private val fragment: BaseFragment) {
  @PerFragment
  @Provides
  fun providesFragment(): BaseFragment {
    return fragment
  }
}
