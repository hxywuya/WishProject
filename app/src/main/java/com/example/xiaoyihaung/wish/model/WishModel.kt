package com.example.xiaoyihaung.wish.model

import com.example.xiaoyihaung.wish.WishDataBase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table

@Table(database = WishDataBase::class)
class WishModel(
        @PrimaryKey
        var id: Int = 0,      //  愿望的ID
        @Column
        var uid: Int = 0,       // 发布愿望的用户ID
        @Column
        var content: String? = null,    //  愿望描述
        @Column
        var images: String? = null,// 图片列表
        @Column
        var create_time: Long = 0,          //  许愿时间
        @Column
        var finish_time: Long = 0,   //  完成时间，为0时为未完成
        @Column
        var time_limit: Long = 0,     //   愿望的期限，可以为0
        @Column
        var type: Int = 0,           //  愿望的类型，0：家庭，1：个人
        @Column
        var open: Int = 0           // 愿望是否公开
)