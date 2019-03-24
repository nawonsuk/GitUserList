package com.mystory.gituserlist.model

import com.mystory.gituserlist.data.data
import retrofit2.http.Query
import rx.Observable

/**
 * ApiManager
 * @author wsseo
 * @since 2019. 3. 14
 **/
class ApiManager(private val apiService: ApiService) : ApiRepository {
    override fun requestGitUserList(query: String, page: Int, perPage: Int): Observable<data>
            = apiService.requestGitUserList(query, page, perPage)
}