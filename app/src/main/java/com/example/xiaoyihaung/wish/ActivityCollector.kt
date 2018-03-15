package com.example.xiaoyihaung.wish

import android.app.Activity
import android.util.Log

/**
 * Created by XiaoYi.Haung on 2018/3/7.
 */
object ActivityCollector {

    var activities: MutableList<Activity> = mutableListOf()

    fun addActivity(activity: Activity) {
        activities.add(activity)
        Log.d("BaseAC", "活动数量 ${activities.size}")
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
        Log.d("BaseAC", "活动数量 ${activities.size}")
    }

    fun finishAll() {
        Log.d("BaseAC", "退出")
        for (activity in activities) {
            Log.d("BaseAC", activity.packageName)
            if (!activity.isFinishing()) {
                activity.finish()
            }
        }
    }
}