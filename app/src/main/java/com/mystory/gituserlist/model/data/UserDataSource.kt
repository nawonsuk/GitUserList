package com.mystory.gituserlist.model.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.PositionalDataSource
import com.mystory.gituserlist.Config
import com.mystory.gituserlist.data.item
import com.mystory.gituserlist.data.data
import com.mystory.gituserlist.model.ApiRepository
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * search data source
 * @author wsseo
 * @since 2019. 3. 24
 **/
class UserDataSource(apiRepository: ApiRepository, state:MutableLiveData<Int>): PositionalDataSource<item>() {
    var apiRepository = apiRepository
    var searchData = MutableLiveData<data>()
    var state:MutableLiveData<Int> = state
    var query:String?=null
    var totalSize:Int = 0
    fun searchQuery(query:String):UserDataSource{
        this.query = query
        return this@UserDataSource
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<item>) {
        query?.let { requestGitUserList(it, 1, params.pageSize, callback, null) }
    }
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<item>) {
        query?.let {
            var position = params.startPosition/params.loadSize+1
            if(totalSize < params.loadSize) position = params.startPosition + 1
            requestGitUserList(it, position, params.loadSize, null, callback)
        }
    }

    fun requestGitUserList(query:String, page:Int, perPage:Int,
                           callbackInit: LoadInitialCallback<item>?,
                           callback: LoadRangeCallback<item>?){
        apiRepository.requestGitUserList(query, page, perPage)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                searchData.value = data
                data?.let {
                    if(it.total_count == 0) state.value = Config.STATE_SEARCH_NO_RESULT
                    totalSize = it.total_count
                }
                data.items?.let { document ->
                    callbackInit?.let {
                        if(totalSize < Config.PAGE_SIZE)
                            it.onResult(document, 0)
                        else
                            it.onResult(document, 0, totalSize)
                    }
                    callback?.let {
                        if(totalSize >= Config.PAGE_SIZE) it.onResult(document)
                    }
                    state.value = Config.STATE_SEARCH_COMPLETE_NORMAL
                }
            }, {
                state.value = Config.STATE_SEARCH_ERROR
            })
    }
}
