package com.example.twitterpresidents.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.twitterpresidents.R
import kotlinx.android.synthetic.main.activity_main.*

class LaunchPage : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendToLogin(view: View) {
        val goToLogin = Intent(this, LoginActivity::class.java)

        if(view == button_chose_to_login){
            goToLogin.putExtra("LOGIN_INTENT_CODE", button_chose_to_login.text.toString())
        } else{
            goToLogin.putExtra("LOGIN_INTENT_CODE", button_chose_to_sign_in.text.toString())
        }
        startActivity(goToLogin)
    }
}
