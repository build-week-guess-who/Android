package com.example.twitterpresidents.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity

import com.example.twitterpresidents.R
import com.example.twitterpresidents.activity.InstructionsScreen
import kotlinx.android.synthetic.main.fragment_tweet_options_bar.*

//includes the ? that launches the instruction, a non clickable guest ui button, end game button, lifebar
class TweetOptionsBar : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_tweet_options_bar, container, false)

        val instructions_btn = view.findViewById<ImageView>(R.id.instructions_launcher)

        instructions_btn.setOnClickListener {
            val intent = Intent(activity as Context, InstructionsScreen::class.java)
            startActivity(intent)
        }

        val end_game_btn = view.findViewById<Button>(R.id.end_game)

        end_game_btn.setOnClickListener {
            val fragment = Endgame()
            val fragmentActivity = context as FragmentActivity
            val fragManager = fragmentActivity.supportFragmentManager
            fragment.show(fragManager, "frag_key")
        }

        return view
    }

}
