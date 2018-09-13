package cn.woyeshi.client.utils

import android.app.Activity
import android.content.Intent
import cn.woyeshi.client.MainActivity

object Navigation {

    fun toMainActivity(activity: Activity) {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
    }

}