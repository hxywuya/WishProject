package com.example.xiaoyihaung.wish

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.xiaoyihaung.wish.util.CommonUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * Created by XiaoYi.Haung on 2018/3/7.
 */
open class BaseActivity: AppCompatActivity() {

    var allowExit: Boolean = false

    var baseTimer: Timer = Timer()

    var baseTask: TimerTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BaseActivity", javaClass.simpleName)
        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        Log.d("ActionBarLayout", CommonUtil.px2dp(this,action_bar.height.toFloat()).toString())
        if (allowExit) {
            ActivityCollector.finishAll()
        } else {
            Toast.makeText(this, "再按一下返回键退出", Toast.LENGTH_SHORT).show()
            baseTimer = Timer()
            baseTask = object : TimerTask() {
                override fun run() {
                    allowExit = false
                }
            }
            allowExit = true
            baseTimer.schedule(baseTask, 1000)
        }
    }
}