package com.mystory.gituserlist.data

import com.google.gson.annotations.SerializedName

/**
 * item 데이타 클래스
 * @author wsseo
 * @since 2019. 3. 24.
 **/
data class item(@SerializedName("id")var id:Int=0,
                @SerializedName("node_id") var node_id:String?="",
                @SerializedName("name") var name:String?="",
                @SerializedName("owner") var owner: owner?=null)