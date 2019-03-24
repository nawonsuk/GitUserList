package com.mystory.gituserlist.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import com.mystory.gituserlist.GitUserListApplication
import com.mystory.gituserlist.di.activity.ActivityModule
import com.mystory.gituserlist.di.application.ApplicationComponent

/**
 * BaseActivity
 * @author wsseo
 * @since 2019. 3. 24
 **/
open class BaseActivity : AppCompatActivity() {
  val screenComponent by lazy {
     getApplicationComponent().activity_plus(ActivityModule(this))
  }
  private fun getApplicationComponent(): ApplicationComponent {
    return (application as GitUserListApplication).component
  }
}