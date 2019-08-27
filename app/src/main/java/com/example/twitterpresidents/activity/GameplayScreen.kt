package com.example.twitterpresidents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.twitterpresidents.R
import com.example.twitterpresidents.adapter.CandidateChoiceListAdapter
import com.example.twitterpresidents.model.PresidentialCandidate
import kotlinx.android.synthetic.main.activity_gameplay_screen.*

//user selects who made the tweet

class GameplayScreen : AppCompatActivity() {

    val presidentialList = mutableListOf<PresidentialCandidate>()
    val candidateListAdapter = CandidateChoiceListAdapter(presidentialList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay_screen)

        //setup recyclerview of candidates

        candidate_choices.setHasFixedSize(true)
        candidate_choices.adapter = candidateListAdapter
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        candidate_choices.layoutManager = manager

        presidentialList.add(PresidentialCandidate(R.drawable.question_mark_outline, "Bernie Sanders", "@feelthebern"))
        presidentialList.add(PresidentialCandidate(R.drawable.question_mark_outline, "Donald Trump", "@realdonaldtrump"))
        presidentialList.add(PresidentialCandidate(R.drawable.question_mark_outline, "Kamala Harris", "@kamalaharris"))

    }
}
