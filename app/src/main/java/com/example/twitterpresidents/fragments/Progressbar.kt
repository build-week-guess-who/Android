package com.example.twitterpresidents.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

import com.example.twitterpresidents.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_gameplay_screen.*
import kotlinx.android.synthetic.main.fragment_progressbar.*
import kotlinx.android.synthetic.main.fragment_progressbar.view.*

//fragment that encapsulates the progress bar

class Progressbar : Fragment() {

//    var instance : Progressbar? = null
    var listener: OnFragmentInteractionListener? = null

    interface OnFragmentInteractionListener {
        fun progressbarMaximized()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_progressbar, container, false)
        view.progressBar.progress = 0
        return view
    }


    //extends progress bar to signify when a correct answer has been given.
    fun extendProgressbar(){
        progressBar.progress += 1
        if(progressBar.progress == 5){
            listener?.progressbarMaximized()
        }
        Log.i("Progresssfdas ", "$progressBar.progress")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Progressbar.OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }
}

