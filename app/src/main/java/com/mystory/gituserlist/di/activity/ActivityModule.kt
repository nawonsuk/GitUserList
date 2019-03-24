package com.mystory.gituserlist.di.activity
import com.mystory.gituserlist.di.scope.PerActivity
import com.mystory.gituserlist.presentation.activity.BaseActivity
import dagger.Module
import dagger.Provides

/**
 * FragmentModule
 * @author wsseo
 * @since 2019. 3. 24
 **/
@Module
class ActivityModule(private val activity: BaseActivity) {
  @PerActivity
  @Provides
  fun providesActivity(): BaseActivity {
    return activity
  }
}
