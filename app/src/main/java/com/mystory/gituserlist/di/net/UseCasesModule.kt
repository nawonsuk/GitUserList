package com.mystory.gituserlist.di.net

import com.mystory.gituserlist.domain.GitUserListInteractor
import com.mystory.gituserlist.domain.GitUserListUseCases
import com.mystory.gituserlist.model.ApiRepository
import dagger.Module
import dagger.Provides

/**
 * UseCasesModule
 * @author wsseo
 * @since 2019. 3. 14
 **/
@Module
class UseCasesModule {
    @Provides
    fun providesGitUserListUseCases(apiRepository: ApiRepository): GitUserListUseCases = GitUserListInteractor(apiRepository)
}