package com.example.xiaoyihaung.wish.activity

import android.os.Bundle
import android.util.Log
import com.example.xiaoyihaung.wish.BaseActivity
import com.example.xiaoyihaung.wish.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_actionbar.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        action_bar.setTitle("愿望")

        left_button.setOnClickListener {
            Log.d("BaseActivity", "点击了按钮")
            main_activity.openDrawer(navigation_view)
        }

        right_button.setOnClickListener {
            Log.d("BaseActivity", "点击了发布")
        }
    }

}
