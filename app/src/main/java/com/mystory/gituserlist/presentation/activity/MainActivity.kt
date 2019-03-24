package com.mystory.gituserlist.presentation.activity

import android.content.Context
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mystory.gituserlist.databinding.ActivityMainBinding
import com.mystory.gituserlist.presentation.viewmodel.MainActViewModel
import android.view.inputmethod.InputMethodManager
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mystory.gituserlist.R
import com.mystory.gituserlist.presentation.adapter.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


/**
 * mainactivity
 * @author wsseo
 * @since 2019. 3. 24
 **/
class MainActivity : BaseActivity() {
    @Inject lateinit var viewModel: MainActViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        screenComponent.inject(this)
        binding.model = viewModel
        tb_main.setupWithViewPager(vp_main)
    }

    /*
        @BindingAdapter({"bind:handler"})
    public static void bindViewPagerAdapter(final ViewPager view, final MainActivity activity)
    {
        final MainActionsAdapter adapter = new MainActionsAdapter(view.getContext(), activity.getSupportFragmentManager());
        view.setAdapter(adapter);
    }

    @BindingAdapter({"bind:pager"})
    public static void bindViewPagerTabs(final TabLayout view, final ViewPager pagerView)
    {
        view.setupWithViewPager(pagerView, true);
    }
     */
    fun hideKeyboard(){
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(et_search.windowToken, 0)
        }catch(e:Exception){

        }
    }
}
