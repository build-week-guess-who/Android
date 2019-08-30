package com.example.twitterpresidents.activity

import android.content.Intent
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.twitterpresidents.R
import kotlinx.android.synthetic.main.activity_victory_screen.*

//import kotlinx.android.synthetic.main.activity_victory_screen.*


class VictoryScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory_screen)

        play_again_button.setOnClickListener{
            intent = Intent(this, ModeSelection::class.java)
            startActivity(intent)
        }

        quit_button.setOnClickListener{

                finish();
                System.exit(0)

        }
    }
}



