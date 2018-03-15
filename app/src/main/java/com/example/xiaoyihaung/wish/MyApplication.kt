package com.example.xiaoyihaung.wish

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by XiaoYi.Haung on 2018/3/5.
 */
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}