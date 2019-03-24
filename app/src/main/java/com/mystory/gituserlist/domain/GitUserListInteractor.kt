package com.mystory.gituserlist.domain

import androidx.lifecycle.MutableLiveData
import com.mystory.gituserlist.model.ApiRepository
import com.mystory.gituserlist.model.data.UserDataSource

/**
 * GitUserListInteractor
 * @author wsseo
 * @since 2019. 3. 24
 **/
class GitUserListInteractor(private val apiRepository: ApiRepository) : GitUserListUseCases {
    override fun getUserDataSource(query:String, state:MutableLiveData<Int>): UserDataSource {
        return UserDataSource(apiRepository, state).searchQuery(query)
    }
}