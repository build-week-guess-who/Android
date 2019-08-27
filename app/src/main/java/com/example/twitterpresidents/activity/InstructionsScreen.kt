package com.example.twitterpresidents.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.twitterpresidents.R
import kotlinx.android.synthetic.main.activity_instructions_screen.*

class InstructionsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions_screen)

        //for now simply starts the gameplay screen
        single_player_button.setOnClickListener {
            val intent = Intent(this, GameplayScreen::class.java)
            startActivity(intent)
        }
    }
}
