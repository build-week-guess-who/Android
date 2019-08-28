package com.example.twitterpresidents.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterpresidents.R
import com.example.twitterpresidents.activity.GameplayScreen
import com.example.twitterpresidents.model.PresidentialCandidate
import kotlinx.android.synthetic.main.candidate_choice.view.*

class CandidateChoiceListAdapter(val data : MutableList<PresidentialCandidate>) : RecyclerView.Adapter<CandidateChoiceListAdapter.ViewHolder>() {

    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        val portrait : ImageView = view.candidate_portrait
        val name : TextView = view.candidate_name
        val twitter_handle : TextView = view.candidate_handle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.candidate_choice, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.portrait.setImageDrawable(ContextCompat.getDrawable(holder.view.context, data[position].portraitId))
        holder.name.text = data[position].name
        holder.twitter_handle.text = data[position].twitterHandle

        //determine if the choice is the correct one.
        holder.view.setOnClickListener {
            Log.i("EWRWER", "WEEW")
            if(position == GameplayScreen.correctAnswer){
                //play sound that signifies its the right answer, update progress bar
                GameplayScreen.soundPool?.play(R.raw.correct_sound, 1f, 1f, 0, 0, 1f)

            } else{
                //play sound signifying wrong answer
                GameplayScreen.soundPool?.play(R.raw.wrong_sound, 1f, 1f, 0, 0, 1f)
            }
            //play transition to the next screen
        }
    }

}