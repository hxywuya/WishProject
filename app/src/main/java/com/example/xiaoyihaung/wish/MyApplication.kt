package com.example.xiaoyihaung.wish

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.raizlabs.android.dbflow.config.FlowManager

/**
 * Created by XiaoYi.Haung on 2018/3/5.
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        // 初始化图片加载框架Fresco
        Fresco.initialize(this)
        // 初始化数据库框架DBFlow
        FlowManager.init(this)
    }
}