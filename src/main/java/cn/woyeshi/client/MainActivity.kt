package cn.woyeshi.client

import android.os.Bundle
import cn.woyeshi.base.activities.BaseActivity

class MainActivity : BaseActivity() {
    override fun getContentLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun isHaveTitleBar(): Boolean {
        return false
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

    }

}
