package com.example.xiaoyihaung.wish.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.xiaoyihaung.wish.BaseActivity
import com.example.xiaoyihaung.wish.R
import com.example.xiaoyihaung.wish.layout.ActionbarLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        action_bar.setTitle("愿望")
        action_bar.setLeftButton("res://" + baseContext.packageName + "/" + R.drawable.header, object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("BaseActivity", "点击了按钮")
                main_activity.openDrawer(navigation_view)
            }
        },ActionbarLayout.IMAGE)
        action_bar.setRightButton("发布",object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("BaseActivity", "点击了发布")

                val intent = Intent(this@MainActivity, PushActivity::class.java)
                startActivity(intent)
            }
        }, ActionbarLayout.TEXT)

    }



}
