package com.tommasoberlose.roundedbutton

import android.annotation.TargetApi
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.TintContextWrapper
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

/**
 * Created by tommaso on 04/08/17.
 */

class RoundedButton : LinearLayout {

    internal var rounded: Boolean = false
    internal var loading: Boolean = false
    internal var animate: Boolean = false
    internal lateinit var loader: ProgressBar
    lateinit var button: CardView
    lateinit var text: TextView

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context)
    }

    fun init(context: Context) {
        View.inflate(context, R.layout.rounded_button_layout, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        button = findViewById(R.id.card)
        loader = findViewById(R.id.progressLoader)
        text = findViewById(R.id.button_text)
    }

    fun setRounded(rounded: Boolean) {
        this.rounded = rounded
        if (rounded) {
            button.radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24f, resources.displayMetrics);
        } else {
            Toast.makeText(this.context, "BOH2: " + button.radius, Toast.LENGTH_SHORT).show()
            button.radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f, resources.displayMetrics);
        }
    }

    fun setButtonLoading(loading: Boolean) {
        this.loading = loading
        if (animate) {
            text.animate().alpha(if (loading) 0f else 1f).start()
            loader.animate().alpha(if (!loading) 0f else 1f).start()
        } else {
            text.visibility = if (loading) View.GONE else View.VISIBLE
            loader.visibility = if (!loading) View.GONE else View.VISIBLE
        }
    }

    fun isButtonLoading(): Boolean {
        return loading
    }

    /* Button Settings */
    fun setButtonBackground(color: Int) {
        button.setCardBackgroundColor(color)
    }

    fun setButtonBackground(colorStateList: ColorStateList) {
        button.cardBackgroundColor = colorStateList
    }

    /* ProgressBar Settings*/

    fun setProgressBarColor(@ColorRes color: Int) {
        loader.indeterminateDrawable.setColorFilter(ContextCompat.getColor(this.context, color), PorterDuff.Mode.MULTIPLY)
    }


    /* TextView Settings */

    fun animateTextChanges(animate: Boolean) {
        this.animate = animate
    }

    fun setText(text: CharSequence, type: TextView.BufferType) {
        this.text.setText(text, type)
    }

    fun setText(text: CharArray, start: Int, len: Int) {
        this.text.setText(text, start, len)
    }

    fun setTextKeepState(text: CharSequence, type: TextView.BufferType) {
        this.text.setText(text, type)
    }

    fun setText(resid: Int) {
        this.text.setText(resid)
    }

    fun setText(resid: Int, type: TextView.BufferType) {
        this.text.setText(resid, type)
    }

    fun setButtonTextColor(color: Int) {
        text.setTextColor(color)
    }

    fun setButtonTextColor(colorStateList: ColorStateList) {
        text.setTextColor(colorStateList)
    }

    fun setButtonTextAllCaps(allCaps: Boolean) {
        text.setAllCaps(allCaps)
    }

    fun setButtonTextTypeface(tf: Typeface, style: Int) {
        text.setTypeface(tf, style)
    }

}
