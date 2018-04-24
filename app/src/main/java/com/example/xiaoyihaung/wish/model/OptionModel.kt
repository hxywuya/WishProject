package com.example.xiaoyihaung.wish.model

import android.util.Log
import com.example.xiaoyihaung.wish.WishDataBase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.kotlinextensions.eq
import com.raizlabs.android.dbflow.kotlinextensions.from
import com.raizlabs.android.dbflow.kotlinextensions.select
import com.raizlabs.android.dbflow.kotlinextensions.where

@Table(database = WishDataBase::class)
class OptionModel(
        @PrimaryKey
        var name: String? = null,   // 选项名称
        @Column
        var content: String? = null  // 选项内容
) {
    open fun getDataBaseInfo() : HashMap<String, String>? {
        val info = (select
                from this::class
                where(OptionModel_Table.name eq "DBInfo")).querySingle()

        if (info != null) {
            Log.d("DataBase", info.content)
            val gson = Gson()
            val hminfo: HashMap<String, String> = gson.fromJson(info.content, object : TypeToken<HashMap<String, String>>(){}.type)
            return hminfo
//            return info.content!!
        }
        return null
    }
}