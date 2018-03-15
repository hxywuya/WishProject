package com.example.xiaoyihaung.wish.util

import android.content.Context

/**
 * Created by XiaoYi.Haung on 2018/3/8.
 */
object CommonUtil {

    /**
     * 计算时间间隔（年 月 日 时 分 秒）
     * 当time1 - time2 小于0时返回 out
     * time1 结束时间
     * time2 起始时间
     */
    fun timeInterval(time1: Long, time2: Long): String {
        val interval: Long = time1 - time2
        var intervalStr: String = ""
        //  超出
        if (interval < 0) {
            return "out"
        }
        //  低于1分钟
        if (interval < 60) {
            intervalStr = interval.toString() + "秒后过期"
        }
        // 低于1小时
        if (interval < 3600) {
            intervalStr = (interval / 60).toString() + "分钟后过期"
        }
        // 低于1天
        if (interval < 86400) {
            intervalStr = (interval / 3600).toString() + "小时后过期"
        }
        // 大于1天
        if (interval > 86400) {
            intervalStr = (interval / 86400).toString() + "天后过期"
        }
        return intervalStr
    }

    /**
     * dp转换成px
     */
    fun dp2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * px转换成dp
     */
    fun px2dp(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * sp转换成px
     */
    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }

    /**
     * px转换成sp
     */
    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }
}