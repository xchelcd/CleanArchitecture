package com.example.cleanarchitecture.ui.home

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.model.Post
import com.example.cleanarchitecture.databinding.WidgetHomeItemBinding

class HomeItem(
    context: Context,
    attrs: AttributeSet?
) : LinearLayout(context, attrs) {

    var data: Post? = null
        set(value) {
            field = value
            binding.apply {
                title1 = data?.title
                title2 = "2.-${data?.title}"
            }
        }

    private val binding: WidgetHomeItemBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.widget_home_item,
        this,
        true
    )

}