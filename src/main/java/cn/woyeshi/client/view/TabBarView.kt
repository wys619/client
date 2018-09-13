package cn.woyeshi.client.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.CompoundButton
import android.widget.LinearLayout
import cn.woyeshi.client.R
import kotlinx.android.synthetic.main.view_tab_bar.view.*

class TabBarView : LinearLayout, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    var onTabSelectedListener: IOnTabSelectedListener? = null

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.view_tab_bar, this, true)
        initViews()
    }

    private fun initViews() {
        llMainTab.setOnClickListener(this)
        llCategoryTab.setOnClickListener(this)
        llMsgTab.setOnClickListener(this)
        llCartTab.setOnClickListener(this)
        llMyTab.setOnClickListener(this)
        cbMainTab.setOnCheckedChangeListener(this)
        cbCategoryTab.setOnCheckedChangeListener(this)
        cbCartTab.setOnCheckedChangeListener(this)
        cbMsgTab.setOnCheckedChangeListener(this)
        cbMyTab.setOnCheckedChangeListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.llMainTab -> {
                cbMainTab.isChecked = true
                cbCategoryTab.isChecked = false
                cbCartTab.isChecked = false
                cbMsgTab.isChecked = false
                cbMyTab.isChecked = false

                cbMainTabText.isChecked = true
                cbCategoryTabText.isChecked = false
                cbCartTabText.isChecked = false
                cbMsgTabText.isChecked = false
                cbMyTabText.isChecked = false
            }
            R.id.llCategoryTab -> {
                cbMainTab.isChecked = false
                cbCategoryTab.isChecked = true
                cbCartTab.isChecked = false
                cbMsgTab.isChecked = false
                cbMyTab.isChecked = false
                cbMainTabText.isChecked = false
                cbCategoryTabText.isChecked = true
                cbCartTabText.isChecked = false
                cbMsgTabText.isChecked = false
                cbMyTabText.isChecked = false
            }
            R.id.llCartTab -> {
                cbMainTab.isChecked = false
                cbCategoryTab.isChecked = false
                cbCartTab.isChecked = true
                cbMsgTab.isChecked = false
                cbMyTab.isChecked = false
                cbMainTabText.isChecked = false
                cbCategoryTabText.isChecked = false
                cbCartTabText.isChecked = true
                cbMsgTabText.isChecked = false
                cbMyTabText.isChecked = false
            }
            R.id.llMsgTab -> {
                cbMainTab.isChecked = false
                cbCategoryTab.isChecked = false
                cbCartTab.isChecked = false
                cbMsgTab.isChecked = true
                cbMyTab.isChecked = false
                cbMainTabText.isChecked = false
                cbCategoryTabText.isChecked = false
                cbCartTabText.isChecked = false
                cbMsgTabText.isChecked = true
                cbMyTabText.isChecked = false
            }
            R.id.llMyTab -> {
                cbMainTab.isChecked = false
                cbCategoryTab.isChecked = false
                cbCartTab.isChecked = false
                cbMsgTab.isChecked = false
                cbMyTab.isChecked = true
                cbMainTabText.isChecked = false
                cbCategoryTabText.isChecked = false
                cbCartTabText.isChecked = false
                cbMsgTabText.isChecked = false
                cbMyTabText.isChecked = true
            }
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        if (!isChecked) {
            return
        }
        val id = buttonView.id
        onTabSelectedListener?.onTabSelected(id)
    }

    fun checkTab(cbId: Int) {
        when (cbId) {
            R.id.cbMainTab -> {
                llMainTab.performClick()
            }
            R.id.cbCategoryTab -> {
                llCategoryTab.performClick()
            }
            R.id.cbCartTab -> {
                llCartTab.performClick()
            }
            R.id.cbMsgTab -> {
                llMsgTab.performClick()
            }
            R.id.cbMyTab -> {
                llMyTab.performClick()
            }
        }
    }

//    fun showRedPoint(flag: Boolean) {
//        if (flag) {
//            newsRedPoint.visibility = View.VISIBLE
//        } else {
//            newsRedPoint.visibility = View.GONE
//        }
//    }

    interface IOnTabSelectedListener {
        fun onTabSelected(tabId: Int)
    }

}