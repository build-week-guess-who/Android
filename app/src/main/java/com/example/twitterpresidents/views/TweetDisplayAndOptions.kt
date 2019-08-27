package com.example.twitterpresidents.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.example.twitterpresidents.fragments.Lifebar
import com.example.twitterpresidents.fragments.Progressbar

class TweetDisplayAndOptions(context : Context, attrs : AttributeSet) : View(context, attrs),
    Lifebar.OnFragmentInteractionListener, Progressbar.OnFragmentInteractionListener {

    override fun noMoreLives() {

    }

    override fun progressbarMaximized() {

    }
}