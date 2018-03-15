package com.example.xiaoyihaung.wish.model

/**
 * Created by XiaoYi.Haung on 2018/3/9.
 */
data class Wish (
        var title: String,      //  愿望的标题
        var content: String,    //  愿望描述
        var images: Array<String>,// 图片列表
        var time: Long,          //  许愿时间
        var finishTime: Long,   //  完成时间，为0时为未完成
        var timeLimit: Long,     //   愿望的期限，可以为0
        var type: Int           //  愿望的类型，0：家庭，1：个人
)