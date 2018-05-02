package com.example.xiaoyihaung.wish.model

import com.example.xiaoyihaung.wish.WishDataBase
import com.google.gson.Gson
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.kotlinextensions.*

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
) {
    open fun getWishList(): List<Wish> {
        val wishModelList = (select
                from(WishModel::class)
                orderBy(WishModel_Table.id.desc())
                limit(10)).list
        var wishList: MutableList<Wish> = ArrayList()
        val gson = Gson()
        for (wishModel in wishModelList){
            wishList.add(Wish(
                    wishModel.id,
                    wishModel.uid,
                    wishModel.content!!,
                    gson.fromJson(wishModel.images, Array<String>::class.java),
                    wishModel.create_time,
                    wishModel.finish_time,
                    wishModel.time_limit,
                    wishModel.type,
                    wishModel.open))
        }
        return wishList
    }

    open fun saveData(wish: Wish) {
        val gson = Gson()
        id = wish.id
        uid = wish.uid
        content = wish.content
        images = gson.toJson(wish.images)
        create_time = wish.create_time
        finish_time = wish.finish_time
        time_limit = wish.time_limit
        type = wish.type
        open = wish.open
        save()
    }

    open fun saveData(wish: WishModel) {
        id = wish.id
        uid = wish.uid
        content = wish.content
        images = wish.images
        create_time = wish.create_time
        finish_time = wish.finish_time
        time_limit = wish.time_limit
        type = wish.type
        open = wish.open
        save()
    }

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
}