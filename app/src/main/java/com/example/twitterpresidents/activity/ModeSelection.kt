package com.example.twitterpresidents.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.twitterpresidents.R
import kotlinx.android.synthetic.main.activity_instructions_screen.*
import kotlinx.android.synthetic.main.activity_mode_selection.*

//user selects a mode, e.g. single player or multiplayer
class ModeSelection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_selection)
    }

    fun goToGame(view: View){
        val intent = Intent(this, GameplayScreen::class.java)
        if(view.id == R.id.multiplayer_button) {
            intent.putExtra("IS_MULTIPLAYER", true)
        } else{
            intent.putExtra("IS_MULTIPLAYER", false)
        }
        startActivity(intent)
    }
}