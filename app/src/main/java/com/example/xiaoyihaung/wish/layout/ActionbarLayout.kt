package com.example.xiaoyihaung.wish.layout

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.example.xiaoyihaung.wish.R
import kotlinx.android.synthetic.main.include_actionbar.view.*


/**
 * Created by XiaoYi.Haung on 2018/3/6.
 */
class ActionbarLayout(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.include_actionbar, this)
    }

    open fun setTitle(text: String) {
        title.text = text
    }
}