package com.mystory.gituserlist.presentation.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

/**
 * ApiRecyclerViewModel
 * @author wsseo
 * @since 2019. 3. 17
 **/
class LocalRecyclerViewModel(name:String?, image_url:String?) : BaseObservable(){
    var name = ObservableField<String>()
    var image_url = ObservableField<String>()
    init {
        this.name.set(name)
        this.image_url.set(image_url)
    }
}