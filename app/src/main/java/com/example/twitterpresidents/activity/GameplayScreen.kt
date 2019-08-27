package com.example.twitterpresidents.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.twitterpresidents.R
import com.example.twitterpresidents.adapter.CandidateChoiceListAdapter
import com.example.twitterpresidents.fragments.Lifebar
import com.example.twitterpresidents.fragments.Progressbar
import com.example.twitterpresidents.model.PresidentialCandidate
import kotlinx.android.synthetic.main.activity_gameplay_screen.*

//user selects who made the tweet

class GameplayScreen : AppCompatActivity(), Lifebar.OnFragmentInteractionListener,
    Progressbar.OnFragmentInteractionListener {

    companion object {
        val presidentialList = mutableListOf<PresidentialCandidate>()
        val candidateListAdapter = CandidateChoiceListAdapter(presidentialList)
        var correctAnswer : Int = -1 //randomly generates which selection is correct.
        get(){
            return (0..3).random()
        }
    }

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
        candidateListAdapter.notifyDataSetChanged()
    }

    override fun noMoreLives() {
        //call game over screen...restart game

    }

    override fun progressbarMaximized() {
        //move to screen where exp is accumulated
    }
}
