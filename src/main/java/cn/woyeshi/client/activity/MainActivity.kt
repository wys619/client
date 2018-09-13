package cn.woyeshi.client.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import cn.woyeshi.base.activities.BaseActivity
import cn.woyeshi.client.R
import cn.woyeshi.client.fragment.*
import cn.woyeshi.client.view.TabBarView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val homeFragment by lazy { HomeFragment() }
    private val categoryFragment by lazy { CategoryFragment() }
    private val cartFragment by lazy { CartFragment() }
    private val msgFragment by lazy { MsgFragment() }
    private val myFragment by lazy { MyFragment() }


    override fun getContentLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun isHaveTitleBar(): Boolean {
        return false
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        tabBarView.onTabSelectedListener = object : TabBarView.IOnTabSelectedListener {
            override fun onTabSelected(tabId: Int) {
                when (tabId) {
                    R.id.cbMainTab -> {
                        switchToFragment(homeFragment)
                    }
                    R.id.cbCategoryTab -> {
                        switchToFragment(categoryFragment)
                    }
                    R.id.cbCartTab -> {
                        switchToFragment(cartFragment)
                    }
                    R.id.cbMsgTab -> {
                        switchToFragment(msgFragment)
                    }
                    R.id.cbMyTab -> {
                        switchToFragment(myFragment)
                    }
                }
            }

        }
        tabBarView.checkTab(R.id.cbMainTab)
    }

    private fun switchToFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.tabContainer, fragment).commitAllowingStateLoss()
    }

}
