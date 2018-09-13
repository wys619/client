package cn.woyeshi.client.activity

import android.os.Bundle
import android.os.Handler
import cn.woyeshi.base.activities.BaseActivity
import cn.woyeshi.client.R
import cn.woyeshi.client.utils.Navigation

class SplashActivity : BaseActivity() {
    override fun getContentLayoutID(): Int {
        return R.layout.activity_splash
    }

    override fun isHaveTitleBar(): Boolean {
        return false
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Handler().postDelayed({
            Navigation.toMainActivity(this@SplashActivity)
            finish()
        }, 2000)
    }
}