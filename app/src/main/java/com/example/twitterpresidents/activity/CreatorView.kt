package com.example.twitterpresidents.activity

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.twitterpresidents.R


class CreatorView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    init {

        inflate(context, R.layout.creator_layout, this)

        val imageView: ImageView = findViewById(R.id.image)
        val textView: TextView = findViewById(R.id.caption)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CreatorView)

        imageView.setImageDrawable(attributes.getDrawable(R.styleable.CreatorView_image))

        textView.text = attributes.getString(R.styleable.CreatorView_text)

        attributes.recycle()
    }

}

