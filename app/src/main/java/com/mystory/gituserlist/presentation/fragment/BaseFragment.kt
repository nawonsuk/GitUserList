package com.mystory.gituserlist.presentation.fragment

import androidx.fragment.app.Fragment
import com.mystory.gituserlist.GitUserListApplication
import com.mystory.gituserlist.di.application.ApplicationComponent
import com.mystory.gituserlist.di.fragment.FragmentModule

open class BaseFragment : Fragment() {
  val screenComponent by lazy {
     getApplicationComponent().fragment_plus(FragmentModule(this))
  }
  private fun getApplicationComponent(): ApplicationComponent {
    return (activity as GitUserListApplication).component
  }
}