package com.example.twitterpresidents.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.twitterpresidents.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.text = intent.getStringExtra("LOGIN_INTENT_CODE")

        button_login.setOnClickListener{
            if(editText.text.toString() != "" && editText2.text.toString() != "") {
                val goToMode = Intent(this, ModeSelection::class.java)
                startActivity(goToMode)
            }
        }
    }
}
