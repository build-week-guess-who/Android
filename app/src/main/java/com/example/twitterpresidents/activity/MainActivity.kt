package com.example.guesswho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.twitterpresidents.R
import com.example.twitterpresidents.R.*
import com.example.twitterpresidents.R.layout.*
import com.example.twitterpresidents.activity.loginActivity
import kotlinx.android.synthetic.main.activity_main.*

const val LOGIN_INTENT_CODE = 1

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        button_log_in.setOnClickListener{
            val goToLogin = Intent(this@MainActivity, loginActivity::class.java)
            goToLogin.putExtra("LOGIN_INTENT_CODE", 1)
            startActivity(goToLogin)
        }
    }
}
//initial commit