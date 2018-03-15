package com.example.xiaoyihaung.wish.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.xiaoyihaung.wish.R
import com.example.xiaoyihaung.wish.model.Wish
import com.example.xiaoyihaung.wish.util.CommonUtil
import com.facebook.drawee.view.SimpleDraweeView
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by XiaoYi.Haung on 2018/3/12.
 */
class WishAdapter(private var mList:List<Wish>):RecyclerView.Adapter<WishAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wish, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mitem = mList[position]

        if (mitem.images.size > 0){
            holder.mHeaderImage.visibility = View.VISIBLE
            holder.mHeaderImage.setImageURI(mitem.images[0])
        }

        holder.mTitle.text = mitem.title
        holder.mTime.text = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date(mitem.time * 1000))

        var interval = ""
        if (mitem.finishTime > 0) {
            interval = "达成日期" + SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date(mitem.finishTime * 1000))
        } else {
            interval = CommonUtil.timeInterval(mitem.timeLimit, System.currentTimeMillis() / 1000)
            if (interval == "out") {
                interval = "残念，许愿失败"
            }
        }
        holder.mTimeLimit.text = interval

        holder.mContent.text = mitem.content

        holder.mView.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ViewHolder(val mView: View): RecyclerView.ViewHolder(mView) {
        val mHeaderImage: SimpleDraweeView
        val mTitle: TextView
        val mTime: TextView
        val mTimeLimit: TextView
        val mContent: TextView

        init {
            mHeaderImage = mView.findViewById(R.id.head_image) as SimpleDraweeView
            mTitle = mView.findViewById(R.id.title) as TextView
            mTime = mView.findViewById(R.id.time) as TextView
            mTimeLimit = mView.findViewById(R.id.time_limit) as TextView
            mContent = mView.findViewById(R.id.content) as TextView
        }
    }
}