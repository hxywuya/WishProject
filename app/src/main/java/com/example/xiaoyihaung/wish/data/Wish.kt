package com.example.xiaoyihaung.wish.data

/**
 * Created by XiaoYi.Haung on 2018/3/9.
 */
data class Wish (
        var id: Int,      //  愿望的ID
        var uid: Int,       // 发布愿望的用户ID
        var content: String,    //  愿望描述
        var images: Array<String>,// 图片列表
        var create_time: Long,          //  许愿时间
        var finish_time: Long,   //  完成时间，为0时为未完成
        var time_limit: Long,     //   愿望的期限，可以为0
        var type: Int,           //  愿望的类型，0：家庭，1：个人
        var open: Int           // 愿望是否公开
)