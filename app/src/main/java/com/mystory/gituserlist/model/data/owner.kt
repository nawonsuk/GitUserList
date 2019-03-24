package com.mystory.gituserlist.data

import com.google.gson.annotations.SerializedName

/**
 * owner 데이타 클래스
 * @author wsseo
 * @since 2019. 3. 24.
 **/
data class owner(@SerializedName("id")var id:Int=0,
                 @SerializedName("avatar_url")var avatar_url:String?=null,
                 @SerializedName("received_events_Url") var received_events_Url:String?=null)