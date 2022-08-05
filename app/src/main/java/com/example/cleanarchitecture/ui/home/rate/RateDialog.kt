package com.example.cleanarchitecture.ui.home.rate

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.cleanarchitecture.data.model.Post
import com.example.cleanarchitecture.databinding.WidgetRateDialogBinding

class RateDialog(
    private val post: Post
): DialogFragment() {

    private lateinit var binding: WidgetRateDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = WidgetRateDialogBinding.inflate(layoutInflater)
        setup()

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(binding.root)

        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false)

        return dialog
    }

    private fun setup() {
        binding.apply {
            setTitle("Rate ${post.title}")
            setHandlerCancel(::handlerCancel)
        }
    }

     fun handlerCancel() {
        dismiss()
    }
}