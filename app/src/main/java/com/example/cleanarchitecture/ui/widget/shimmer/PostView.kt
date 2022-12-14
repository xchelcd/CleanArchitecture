package com.example.cleanarchitecture.ui.widget.shimmer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.cleanarchitecture.R

class PostView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    private val binding: ViewDataBinding? = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.widget_post_load,
        this,
        true
    )
}