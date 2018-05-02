package com.example.xiaoyihaung.wish.layout

import android.content.Context
import android.net.Uri
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.xiaoyihaung.wish.R
import kotlinx.android.synthetic.main.include_actionbar.view.*


/**
 * Created by XiaoYi.Haung on 2018/3/6.
 */
class ActionbarLayout(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    companion object {
        val TEXT: Int = 0
        val IMAGE: Int = 1
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.include_actionbar, this)
    }

    fun setTitle(text: String) {
        title.text = text
//        left_button_image.setImageURI("res://" + context.packageName + "/" + R.drawable.ic_back)
    }

    fun setLeftButton(text: String, m: OnClickListener, type:Int) {
        if (type == TEXT) {
            left_button_text.text = text
            left_button_text.visibility = View.VISIBLE
            left_button_text.setOnClickListener(m)
        } else if (type == IMAGE) {
            left_button_image.setImageURI(text)
            left_button_image.visibility = View.VISIBLE
            left_button_image.setOnClickListener(m)
        }
    }

    fun setRightButton(text: String, m: OnClickListener, type:Int) {
        if (type == TEXT) {
            right_button_text.text = text
            right_button_text.visibility = View.VISIBLE
            right_button_text.setOnClickListener(m)
        } else if (type == IMAGE) {
            right_button_image.setImageURI(text)
            right_button_image.visibility = View.VISIBLE
            right_button_image.setOnClickListener(m)
        }
    }
}