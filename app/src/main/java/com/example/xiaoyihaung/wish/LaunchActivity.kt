package com.example.xiaoyihaung.wish

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.xiaoyihaung.wish.activity.MainActivity
import com.example.xiaoyihaung.wish.model.OptionModel
import java.util.*

class LaunchActivity : BaseActivity() {

    val timer: Timer = Timer()

    internal var task: TimerTask = object : TimerTask() {
        override fun run() {
            //每次需要执行的代码放到这里面。
            val intent: Intent = Intent(this@LaunchActivity, MainActivity::class.java);
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        val optModel= OptionModel()
        val dbInfo = optModel.getDataBaseInfo()
        if (dbInfo != null) {
            Log.d("DateBase", "Ver:" + dbInfo.version + " Create Time:" + dbInfo.create_time + " Update Time:" + dbInfo.update_time)
        }

        timer.schedule(task, 3000)
    }
}
