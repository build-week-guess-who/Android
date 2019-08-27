package com.example.twitterpresidents.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterpresidents.R
import com.example.twitterpresidents.model.PresidentialCandidate
import kotlinx.android.synthetic.main.candidate_choice.view.*

class CandidateChoiceListAdapter(val data : MutableList<PresidentialCandidate>) : RecyclerView.Adapter<CandidateChoiceListAdapter.ViewHolder>() {

    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        val portrait : ImageView = view.candidate_portrait
        val details : TextView = view.candidate_details
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
        holder.details.text = data[position].name + "\n" + data[position].twitterHandle
    }
}