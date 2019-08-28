package com.example.twitterpresidents.fragments

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat

import com.example.twitterpresidents.R
import kotlinx.android.synthetic.main.fragment_lifebar.*
import java.lang.ClassCastException

private const val NUM_LIVES = 3

//fragment that displays the life bar in hearts

class Lifebar : Fragment() {

    var currentLives = 3 //gets reduced when lives we get wrong answer
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lifebar, container, false)
    }

    fun reduceLife(){
        //reduces the heart in the lifebar by 1
        when(currentLives){
            3 ->{
                playHeartAnimation(heart_three as ImageView)
            }
            2 ->{
                playHeartAnimation(heart_two as ImageView)
            }
            1 ->{
                playHeartAnimation(heart_one as ImageView)
            }
        }
        currentLives -= 1
        if(currentLives < 0){
            //launches game over screen

        }
    }

    fun playHeartAnimation(img_view: ImageView){
        val avd = ContextCompat.getDrawable(activity as Context, R.drawable.heart_losing_life)
        img_view.setImageDrawable(avd)
        (avd as Animatable).start()
    }

    //Gameplay screen must implement this
    interface OnFragmentInteractionListener {
        fun noMoreLives()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }
}
