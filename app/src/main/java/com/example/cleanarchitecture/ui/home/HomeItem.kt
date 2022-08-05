package com.example.cleanarchitecture.ui.home

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.model.Post
import com.example.cleanarchitecture.databinding.WidgetHomeItemBinding
import com.example.cleanarchitecture.util.toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

//@AndroidEntryPoint
class HomeItem(
    context: Context,
    attrs: AttributeSet?
) : LinearLayout(context, attrs,), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()

    //@Inject
    //lateinit var getAllPost: GetAllPost

    private val binding: WidgetHomeItemBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.widget_home_item,
        this,
        true
    )

    var data: Post? = null
        set(value) {
            field = value
            binding.data = value
        }

    init {
        // TODO how to do the logic for display all text String.take(static_value) -> String.take(all)
        binding.apply {
            setHandlerDisplayAllText(::handlerDisplayAllText)
            setHandlerSave(::save)
            setHandlerRate(::rate)
            setHandlerDetails(::details)
        }
    }

    private fun save() {
        binding.root.toast("Save")
    }

    private fun rate() {
        binding.root.toast("Rate")
    }

    private fun details() {
        binding.root.toast("Details")
    }

    private fun handlerDisplayAllText() {

    }

}