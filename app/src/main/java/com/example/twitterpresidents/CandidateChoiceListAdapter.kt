package com.example.twitterpresidents

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CandidateChoiceListAdapter(val data : MutableList<PresidentialCandidate>) : RecyclerView.Adapter<CandidateChoiceListAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}