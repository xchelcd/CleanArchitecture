package com.example.cleanarchitecture.util

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter
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