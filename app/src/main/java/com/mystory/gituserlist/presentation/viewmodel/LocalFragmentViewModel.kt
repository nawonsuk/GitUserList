package com.mystory.gituserlist.presentation.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.mystory.gituserlist.Config
import com.mystory.gituserlist.data.item
import com.mystory.gituserlist.domain.GitUserListUseCases
import com.mystory.gituserlist.model.data.UserDataSource
import javax.inject.Inject

/**
 * LocalFragmentViewModel
 * @author wsseo
 * @since 2019. 3. 17
 **/
class LocalFragmentViewModel@Inject constructor(imageSearchListUseCases: GitUserListUseCases) : ViewModel(){
    var obversable : io.reactivex.Observable<PagedList<item>>? = null
    var progressShow = ObservableField<Boolean>()
    var pagedList = MutableLiveData<PagedList<item>>()
    var state = MutableLiveData<Int>()
    var searchDataSource: UserDataSource = imageSearchListUseCases.getUserDataSource("", state)
    var time:Long = 0
    init {
        progressShow.set(false)

        var config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(Config.PAGE_SIZE)
            .setPageSize(Config.PAGE_SIZE)
            .setPrefetchDistance(Config.PAGE_SIZE/2)
            .setEnablePlaceholders(false)
            .build()

        var builder = RxPagedListBuilder<Int, item>(object: DataSource.Factory<Int, item>() {
            override fun create(): DataSource<Int, item>? {
                return searchDataSource
            }
        }, config)

        obversable = builder.buildObservable()
    }
}