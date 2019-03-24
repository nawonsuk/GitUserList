package com.mystory.gituserlist.domain

import androidx.lifecycle.MutableLiveData
import com.mystory.gituserlist.model.data.UserDataSource

/**
 * GitUserListUseCases
 * @author wsseo
 * @since 2019. 3. 24
 **/
interface GitUserListUseCases {
    fun getUserDataSource(query:String, state: MutableLiveData<Int>) : UserDataSource
}