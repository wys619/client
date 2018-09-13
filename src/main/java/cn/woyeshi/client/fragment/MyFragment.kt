package cn.woyeshi.client.fragment

import android.os.Bundle
import cn.woyeshi.base.fragments.BaseFragment
import cn.woyeshi.client.R

class MyFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_me
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



    }
}