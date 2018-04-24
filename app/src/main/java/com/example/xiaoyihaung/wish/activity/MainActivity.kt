package com.example.xiaoyihaung.wish.activity

import android.os.Bundle
import android.util.Log
import com.example.xiaoyihaung.wish.APIServer
import com.example.xiaoyihaung.wish.BaseActivity
import com.example.xiaoyihaung.wish.R
import com.example.xiaoyihaung.wish.data.Wish
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_actionbar.*
import okhttp3.*
import java.io.IOException

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        action_bar.setTitle("愿望")

        left_button.setOnClickListener {
            Log.d("BaseActivity", "点击了按钮")
            main_activity.openDrawer(navigation_view)
        }

        right_button.setOnClickListener {
            Log.d("BaseActivity", "点击了发布")


            val client = OkHttpClient()
            val request = Request.Builder()
//                    .url("http://192.168.11.116/api/wish/getlist")
                    .url("http://192.168.199.132/api/wish/getlist")
                    .build()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {}
                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful()) {//回调的方法执行在子线程。
                        Log.d("kwwl", "获取数据成功了")
                        Log.d("kwwl", "response.code()==" + response.code())
                        val gson = Gson()
//                        val type = object : TypeToken<RequestData>(){}.type
                        val rd = gson.fromJson(response.body()!!.string(), APIServer.RequestData::class.java)
                        Log.d("kwwl", "response.body().string()==" + rd.data.toString())

                        val type = object : TypeToken<ArrayList<Wish>>() {}.type

                        val data: List<Wish> = gson.fromJson(rd.data.toString(), type)
                        Log.d("kwwl", "response.body().string()==" + data[0].content + "size:" + data[0].images.size)
                    }
                }
            })
        }
    }



}
