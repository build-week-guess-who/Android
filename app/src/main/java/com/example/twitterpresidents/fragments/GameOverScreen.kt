package com.example.twitterpresidents.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.example.twitterpresidents.R
import com.example.twitterpresidents.activity.ModeSelection
import kotlinx.android.synthetic.main.fragment_game_over_screen.*


//screen that asks whether the user wants to continue
class GameOverScreen : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game_over_screen, container, false)

        continue_yes.setOnClickListener {
            val intent = Intent(activity as Context, ModeSelection::class.java)
            startActivity(intent)
        }

        continue_no.setOnClickListener {
            activity?.finish()
            System.exit(0)
        }

        return view
    }
}
