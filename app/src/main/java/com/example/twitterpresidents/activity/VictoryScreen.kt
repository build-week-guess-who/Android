package com.example.twitterpresidents.activity

import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.twitterpresidents.R
//import kotlinx.android.synthetic.main.activity_victory_screen.*

var pointer = 0
val drawableIDs = listOf(R.drawable.you_win_animated)
class VictoryScreen : AppCompatActivity() {
    fun animateGif(index: Int) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
            val gifDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(resources, R.drawable.you_win_animated))
            //animated_image.setImageDrawable(gifDrawable)
            (gifDrawable as AnimatedImageDrawable).start()
        }}

    fun incrementpointer(){
        pointer++
        if(pointer >= drawableIDs.size){
            pointer = 0}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory_screen)
        val drawableIDs = listOf( R.drawable.you_win_animated)
        var pointer = 0

    }
}



