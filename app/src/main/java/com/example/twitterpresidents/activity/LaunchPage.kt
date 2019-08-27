package com.example.twitterpresidents.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.twitterpresidents.R
import kotlinx.android.synthetic.main.activity_main.*

class LaunchPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_chose_to_login.setOnClickListener{
            val goToLogin = Intent(this, LoginActivity::class.java)
            goToLogin.putExtra("LOGIN_INTENT_CODE", 1)
            startActivity(goToLogin)


    }
        button_chose_to_sign_in.setOnClickListener{
            val goToSignIn = Intent(this, signIn::class.java)
            startActivity(goToSignIn)
        }
}}
