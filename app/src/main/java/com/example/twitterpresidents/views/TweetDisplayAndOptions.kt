package com.example.twitterpresidents.views

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import com.example.twitterpresidents.activity.ExperienceScreen
import com.example.twitterpresidents.fragments.GameOverScreen
import com.example.twitterpresidents.fragments.Lifebar
import com.example.twitterpresidents.fragments.Progressbar

class TweetDisplayAndOptions(context : Context, attrs : AttributeSet) : View(context, attrs),
    Lifebar.OnFragmentInteractionListener, Progressbar.OnFragmentInteractionListener {

    init{

    }

    override fun noMoreLives() {
        //launches dialog fragment that asks whether you want to replay or not
        val fragment = GameOverScreen()
        val fragmentActivity = context as FragmentActivity
        val fragManager = fragmentActivity.supportFragmentManager
        fragment.show(fragManager, "frag_key")
    }

    override fun progressbarMaximized() {
        //move to experience gaining screen
        val intent = Intent(context, ExperienceScreen::class.java)
    }
}