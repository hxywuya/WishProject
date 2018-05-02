package com.example.xiaoyihaung.wish

import android.util.Log
import com.example.xiaoyihaung.wish.model.WishModel.Wish
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import kotlin.concurrent.thread

class APIServer {

    val ApiAddress = "http://192.168.199.132/api"

    open fun getWishList(callback: Callback<Wish>) {
        thread(start = true) {
            val rd = httpRequest("$ApiAddress/wish/getlist")
            val type = object : TypeToken<ArrayList<Wish>>() {}.type
            if (rd != null) {
                val gson = Gson()
                val data: List<Wish> = gson.fromJson(rd.data.toString(), type)
                Log.d("kwwl", "response.body().string()==" + data[0].content + "size:" + data[0].images.size)
                callback.onSuccess(data)
            }
        }
    }

    private fun httpRequest(url: String): RequestData? {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                        .url(url)
                        .build()
                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    if (response.code() == 200) {
                        val gson = Gson()
                        val rd = gson.fromJson(response.body()!!.string(), RequestData::class.java)
                        return rd
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        return null
    }

    interface Callback<in T> {
        /**
         * 数据成功获取
         */
        fun onSuccess(data:List<T>)

        /**
         * 数据获取失败
         */
        fun onFail(msg: String)
    }

    data class RequestData (
            var status: Int,
            var msg: String,
            var data: Any
    )
}