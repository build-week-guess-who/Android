package com.example.twitterpresidents.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.twitterpresidents.R
import kotlinx.android.synthetic.main.activity_instructions_screen.*
import kotlinx.android.synthetic.main.activity_mode_selection.*

//user selects a mode, e.g. single player or multiplayer
class ModeSelection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_selection)

        //for now simply starts the gameplay screen
        single_player_button.setOnClickListener {
            val intent = Intent(this, GameplayScreen::class.java)
            startActivity(intent)
        }
    }
}