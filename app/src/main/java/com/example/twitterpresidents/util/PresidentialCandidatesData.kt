package com.example.twitterpresidents.util

import com.example.twitterpresidents.R
import com.example.twitterpresidents.model.PresidentialCandidate

class PresidentialCandidatesData {

    companion object {
        lateinit var presidentialCandidates : MutableList<PresidentialCandidate>
    }

    init{
        presidentialCandidates = allCandidateProfiles()
    }

    fun allCandidateProfiles() : MutableList<PresidentialCandidate> {
        val data = mutableListOf<PresidentialCandidate>()

        data.add(PresidentialCandidate(R.drawable.andrew_yang, "Andrew Yang", "@AndrewYang"))
        data.add(PresidentialCandidate(R.drawable.elizabeth_warren, "Elizabeth Warren", "@SenWarren"))
        data.add(PresidentialCandidate(R.drawable.donald_trump, "Donald Trump", "@realDonaldTrump"))
        data.add(PresidentialCandidate(R.drawable.bernie_sanders, "Bernie Sanders", "@BernieSanders"))
        data.add(PresidentialCandidate(R.drawable.kamala_harris, "Kamala Harris", "@KamalaHarris"))

        return data
    }

    fun allTweetData(){

    }
}