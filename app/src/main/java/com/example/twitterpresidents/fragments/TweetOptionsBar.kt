package com.example.twitterpresidents.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity

import com.example.twitterpresidents.R
import com.example.twitterpresidents.activity.InstructionsScreen
import kotlinx.android.synthetic.main.fragment_tweet_options_bar.*

//includes the ? that launches the instruction, a non clickable guest ui button, end game button, lifebar
class TweetOptionsBar : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        instructions_launcher.setOnClickListener {
            val intent = Intent(activity as Context, InstructionsScreen::class.java)
            startActivity(intent)
        }

        end_game.setOnClickListener {
            val fragment = Endgame()
            val fragmentActivity = context as FragmentActivity
            val fragManager = fragmentActivity.supportFragmentManager
            fragment.show(fragManager, "frag_key")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tweet_options_bar, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}
