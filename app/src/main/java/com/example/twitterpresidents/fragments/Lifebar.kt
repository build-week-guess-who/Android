package com.example.twitterpresidents.fragments

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.twitterpresidents.R
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
        currentLives -= 1
        if(currentLives < 0){
            //launches
        }
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
