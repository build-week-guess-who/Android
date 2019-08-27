package com.example.twitterpresidents.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.twitterpresidents.R.layout.*
import kotlinx.android.synthetic.main.activity_main.*

const val LOGIN_INTENT_CODE = 1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        button_chose_to_login.setOnClickListener{
            val goToLogin = Intent(this@MainActivity, LoginActivity::class.java)
            goToLogin.putExtra("LOGIN_INTENT_CODE", 1)
            startActivity(goToLogin)
        }
    }
}
//initial commit