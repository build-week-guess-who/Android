package com.example.twitterpresidents.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.twitterpresidents.R
import kotlinx.android.synthetic.main.fragment_progressbar.*

//fragment that encapsulates the progress bar

class Progressbar : Fragment() {

//    var instance : Progressbar? = null
    var listener: OnFragmentInteractionListener? = null
    var progress = 0

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
        return inflater.inflate(R.layout.fragment_progressbar, container, false)
//        instance = view as Progressbar?
//
//        return view
    }

    //extends progress bar to signify when a correct answer has been given.
    fun extendProgressbar(){
        progress += 1
        progress_text.text = "Progress " + progress.toString()
        if(progress == 5){
            listener?.progressbarMaximized()
        }
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
