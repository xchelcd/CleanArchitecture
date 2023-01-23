package com.example.cleanarchitecture.util

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.ui.home.HomeItem
import com.example.cleanarchitecture.ui.home.HomeList

@BindingAdapter("android:show")
fun show(v: View, visibility: Boolean) {
    v.visibility = if (visibility) View.VISIBLE else View.GONE
}

@BindingAdapter("android:submitLogin")
fun submitLogin(v: View, callback: Callback) {
    v.setOnClickListener { callback() }
}

@BindingAdapter("android:onPress")
fun onPress(v: View, callback: Callback) {
    v.setOnClickListener { callback.invoke() }
}

@BindingAdapter("android:onItemSelected")
fun HomeItem.onItemSelected(callback: CallbackWithObj) {
    this.setOnClickListener { callback(this.data!!) }
}

@BindingAdapter("android:itemSelected")
fun HomeList.itemSelected(callback: CallbackWithObj) {
    //this.setOnItemSelected {
    //    callback.invoke(it)
    //}
}


@BindingAdapter("android:onTextChange")
fun onTextChange(editText: EditText, callback: CallbackWithText) {
    editText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) {
            callback(p0.toString())
        }

    })
}