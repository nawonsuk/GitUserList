package com.mystory.gituserlist.di.application

import com.mystory.gituserlist.GitUserListApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * ApplicationModule
 * @author wsseo
 * @since 2019. 3. 24
 **/
@Module
class ApplicationModule(private val application: GitUserListApplication) {
  @Provides
  @Singleton
  fun provideApplication(): GitUserListApplication {
    return application
  }
}
