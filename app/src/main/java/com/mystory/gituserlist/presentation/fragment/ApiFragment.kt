package com.mystory.gituserlist.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mystory.gituserlist.R
import com.mystory.gituserlist.presentation.adapter.ApiRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_api.*

/**
 * ApiFragment
 * @author wsseo
 * @since 2019. 3. 24
 **/
class ApiFragment : BaseFragment() {
    private val adapter: ApiRecyclerViewAdapter by lazy {
        ApiRecyclerViewAdapter()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_api, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenComponent.inject_api(this)
        initView()
    }

    fun initView(){
        rv_api.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        rv_api.layoutManager = LinearLayoutManager(activity)
        rv_api.setHasFixedSize(true)
        rv_api.adapter = adapter
    }
}