package com.example.xiaoyihaung.wish.activity

import android.os.Bundle
import android.view.View
import com.example.xiaoyihaung.wish.BaseActivity
import com.example.xiaoyihaung.wish.R
import com.example.xiaoyihaung.wish.layout.ActionbarLayout
import kotlinx.android.synthetic.main.activity_push.*

class PushActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push)

        action_bar.setTitle("许愿")
        action_bar.setLeftButton("res://" + baseContext.packageName + "/" + R.drawable.ic_back, object : View.OnClickListener {
            override fun onClick(v: View?) {
                finish()
            }
        }, ActionbarLayout.IMAGE)
        action_bar.setRightButton("发布", object : View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }, ActionbarLayout.TEXT)
    }
}
