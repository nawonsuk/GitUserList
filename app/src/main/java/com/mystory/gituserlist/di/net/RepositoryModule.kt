package com.mystory.gituserlist.di.net

import com.mystory.gituserlist.model.ApiManager
import com.mystory.gituserlist.model.ApiRepository
import com.mystory.gituserlist.model.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * RepositoryModule
 * @author wsseo
 * @since 2019. 3. 24
 **/
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesApiRepository(apiService: ApiService): ApiRepository = ApiManager(apiService)
}