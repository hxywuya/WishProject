package com.example.xiaoyihaung.wish

import android.util.Log
import com.example.xiaoyihaung.wish.data.DBInfo
import com.example.xiaoyihaung.wish.model.OptionModel
import com.google.gson.Gson
import com.raizlabs.android.dbflow.annotation.Database
import com.raizlabs.android.dbflow.annotation.Migration
import com.raizlabs.android.dbflow.kotlinextensions.save
import com.raizlabs.android.dbflow.sql.migration.BaseMigration
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper


@Database(name = WishDataBase.NAME, version = WishDataBase.VERSION)
object WishDataBase {
    const val NAME = "WishDataBase"

    const val VERSION = 1

    @Migration(version = 0, database = WishDataBase::class)
    class DataBaseInit:BaseMigration() {
        override fun onPreMigrate() {
            Log.d("DataBase", "数据库开始初始化")
            super.onPreMigrate()
        }

        override fun migrate(database: DatabaseWrapper) {
            Log.d("DataBase", "数据库正在初始化")
            var optionModel = OptionModel()
            val gson = Gson()
            val dbInfo = DBInfo(VERSION,System.currentTimeMillis())
            optionModel.name = "DBInfo"
            optionModel.content = gson.toJson(dbInfo)
            optionModel.save(database)
        }

        override fun onPostMigrate() {
            Log.d("DataBase", "数据库初始化完成")
            super.onPostMigrate()

        }
    }
}