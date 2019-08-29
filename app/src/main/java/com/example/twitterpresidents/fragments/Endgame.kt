package com.example.twitterpresidents.fragments
//TROYC
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
import com.example.twitterpresidents.activity.GameplayScreen
import com.example.twitterpresidents.activity.ModeSelection
import kotlinx.android.synthetic.main.fragment_endgame.*


//Endgame dialog fragment popup that asks user yes or no whether they'd like to continue with the current game
class Endgame : DialogFragment()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_endgame, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_return_to_mode_selection.setOnClickListener{
            val returnToMode = Intent(getActivity(), ModeSelection::class.java)
            startActivity(returnToMode)

        }
        button_return_to_game.setOnClickListener{
            val returnToGame = Intent(getActivity(), GameplayScreen::class.java)
            //getActivity()!!.supportFragmentManager.popBackStack()
            //not working fix, placeholder code
            getDialog().dismiss()
        }
    }
    }

