package com.mystory.gituserlist.model

import com.mystory.gituserlist.data.data
import rx.Observable

/**
 * API Service interface
 * @author wsseo
 * @since 2019. 3. 14
 **/
interface ApiRepository {
    fun requestGitUserList(q:String, page: Int, perPage: Int) : Observable<data>
}