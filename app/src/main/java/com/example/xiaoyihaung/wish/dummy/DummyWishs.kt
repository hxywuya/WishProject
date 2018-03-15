package com.example.xiaoyihaung.wish.dummy

import com.example.xiaoyihaung.wish.model.Wish
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by XiaoYi.Haung on 2018/3/12.
 */
object DummyWishs {

    var WISHS: List<Wish> = ArrayList()

    val WISHSJSON: String = "[" +
            "{\"title\":\"我的愿望\",\"content\":\"啊！！好想买一台XBOX啊！！\",\"time\":1520845449,\"finishTime\":1521709449,\"timeLimit\":1526979849,\"type\":0}," +
            "{\"title\":\"我的愿望2\",\"content\":\"啊！！好想买SSD啊！！\",\"time\":1520907272,\"finishTime\":0,\"timeLimit\":1526979849,\"type\":0}," +
            "{\"title\":\"我的愿望3\",\"content\":\"啊！！好想买游戏啊！！\",\"time\":1520907272,\"finishTime\":0,\"timeLimit\":1520909498,\"type\":0}," +
            "{\"title\":\"我的愿望3\",\"content\":\"啊！！好想买游戏啊！！\",\"time\":1520907272,\"finishTime\":1520908272,\"timeLimit\":1520909498,\"type\":0}," +
            "{\"title\":\"我的愿望3\",\"content\":\"啊！！好想买游戏啊！！\",\"time\":1520907272,\"finishTime\":1520908272,\"timeLimit\":1520909498,\"type\":0}," +
            "{\"title\":\"我的愿望3\",\"content\":\"啊！！好想买游戏啊！！\",\"time\":1520907272,\"finishTime\":1520908272,\"timeLimit\":1520909498,\"type\":0}" +
            "]"

    init {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Wish>>() {}.type

        WISHS = gson.fromJson(WISHSJSON, type)
    }
}