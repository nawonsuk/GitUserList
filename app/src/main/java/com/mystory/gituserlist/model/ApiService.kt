package com.mystory.gituserlist.model

import com.mystory.gituserlist.data.data
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
* API Service interface
* @author wsseo
* @since 2019. 3. 24
**/
interface ApiService {
    @GET("/search/repositories")
    fun requestGitUserList(@Query("q")q:String, @Query("page") page: Int, @Query("per_page") perPage: Int): Observable<data>
}