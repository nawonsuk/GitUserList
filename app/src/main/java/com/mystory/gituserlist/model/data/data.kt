package com.mystory.gituserlist.data

import com.google.gson.annotations.SerializedName

/**
 * 검색 정보 데이타 클래스
 * @author wsseo
 * @since 2019. 3. 14.
 **/
data class data(@SerializedName("total_count") var total_count:Int=0,
                @SerializedName("incomplete_results")var incomplete_results:Boolean=false,
                @SerializedName("item")var items:List<item>?= null)