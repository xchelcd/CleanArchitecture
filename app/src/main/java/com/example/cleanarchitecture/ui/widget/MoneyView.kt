package com.example.cleanarchitecture.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.WidgetMoneyViewBinding
import com.example.cleanarchitecture.util.dpToPx
import java.text.NumberFormat

class MoneyView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val format: NumberFormat by lazy { NumberFormat.getCurrencyInstance() }
    private var numberDecimals: Int = 2

    private val bind: WidgetMoneyViewBinding = DataBindingUtil
        .inflate(
            LayoutInflater.from(context),
            R.layout.widget_money_view,
            this,
            true
        )

    init {
        orientation = HORIZONTAL
        bind.apply {
            showSymbol = true
        }
        context.theme.obtainStyledAttributes(attrs, R.styleable.MoneyView, 0, 0).apply {
            try {
                getColor(
                    R.styleable.MoneyView_color,
                    context.getColor(R.color.white)
                ).let(::setColor)
                getFloat(R.styleable.MoneyView_value, 0f).let(::setValue)
                getString(R.styleable.MoneyView_symbol).let(::setSymbol)
                getString(R.styleable.MoneyView_code).let(::setCode)
                getBoolean(R.styleable.MoneyView_showSymbol, true).let(::setShowSymbol)
                getDimension(
                    R.styleable.MoneyView_fontSize,
                    context.dpToPx(12).toFloat()
                ).let(::setFontSize)
                getFloat(R.styleable.MoneyView_scale, 1f).let(::setScale)
                getInt(R.styleable.MoneyView_numberDecimals, 2).let {
                    numberDecimals = it
                }
            } finally {
                recycle()
            }
        }
    }

    fun setScale(scale: Float) {
        bind.scale = scale
    }

    fun setFontSize(size: Float) {
        if (size == 0f) return
        bind.size = size
    }

    fun setShowSymbol(showSymbol: Boolean) {
        bind.showSymbol = showSymbol
    }

    fun setValue(value: Float?) {
        if (value == null) return
        format.maximumFractionDigits = numberDecimals
        bind.value = format.format(value).removePrefix("$")
    }

    fun setValue(value: String?) {
        try {
            if (value == null) return
            format.maximumFractionDigits = numberDecimals
            bind.value = format.format(value.toFloat()).removePrefix("$")
        } catch (e: Exception) {
            println(">>: MoneyView.setValue.error: { value: $value, error: $e }")
        }
    }

    fun setSymbol(symbol: String?) {
        bind.symbol = symbol ?: "$"
    }

    fun setCode(code: String?) {
        bind.code = code ?: "MXN"
    }

    fun setColor(color: Int) {
        try {
            bind.color = color
        } catch (e: Exception) {
            bind.color = context.getColor(R.color.white)
        }
    }

}