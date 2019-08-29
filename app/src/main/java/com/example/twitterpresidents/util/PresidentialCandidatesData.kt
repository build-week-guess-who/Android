package com.example.twitterpresidents.util

import com.example.twitterpresidents.R
import com.example.twitterpresidents.model.PresidentialCandidate

class PresidentialCandidatesData {

    lateinit var presidentialCandidates : MutableList<PresidentialCandidate>
    lateinit var candidateTweets : kotlin.collections.MutableMap<PresidentialCandidate, MutableList<String>>

    init{
        presidentialCandidates = allCandidateProfiles()
        candidateTweets = allTweetData()
    }

    fun allCandidateProfiles() : MutableList<PresidentialCandidate> {
        val data = mutableListOf<PresidentialCandidate>()

        data.add(PresidentialCandidate(R.drawable.donald_trump, "Donald Trump", "@realDonaldTrump"))
        data.add(PresidentialCandidate(R.drawable.kamala_harris, "Kamala Harris", "@KamalaHarris"))
        data.add(PresidentialCandidate(R.drawable.andrew_yang, "Andrew Yang", "@AndrewYang"))
        data.add(PresidentialCandidate(R.drawable.elizabeth_warren, "Elizabeth Warren", "@SenWarren"))
        data.add(PresidentialCandidate(R.drawable.bernie_sanders, "Bernie Sanders", "@BernieSanders"))

        return data
    }

    fun allTweetData() : MutableMap<PresidentialCandidate, MutableList<String>>{
        val tweetCandidateMap = mutableMapOf<PresidentialCandidate, MutableList<String>>()

        val trumpTweets = mutableListOf<String>()
        trumpTweets.add("Trump tweet 1")
        trumpTweets.add("Trump tweet 2")
        trumpTweets.add("Trump tweet 3")
        trumpTweets.add("Trump tweet 4")
        trumpTweets.add("Trump tweet 5")

        tweetCandidateMap.put(presidentialCandidates[0], trumpTweets)

        val harrisTweets = mutableListOf<String>()
        harrisTweets.add("Harris tweet 1")
        harrisTweets.add("Harris tweet 2")
        harrisTweets.add("Harris tweet 3")
        harrisTweets.add("Harris tweet 4")
        harrisTweets.add("Harris tweet 5")

        tweetCandidateMap.put(presidentialCandidates[1], harrisTweets)

        val yangTweets = mutableListOf<String>()
        yangTweets.add("Yang tweet 1")
        yangTweets.add("Yang tweet 2")
        yangTweets.add("Yang tweet 3")
        yangTweets.add("Yang tweet 4")
        yangTweets.add("Yang tweet 5")

        tweetCandidateMap.put(presidentialCandidates[2], yangTweets)

        val warrenTweets = mutableListOf<String>()
        warrenTweets.add("Warren tweet 1")
        warrenTweets.add("Warren tweet 2")
        warrenTweets.add("Warren tweet 3")
        warrenTweets.add("Warren tweet 4")
        warrenTweets.add("Warren tweet 5")

        tweetCandidateMap.put(presidentialCandidates[3], warrenTweets)

        val sandersTweets = mutableListOf<String>()
        sandersTweets.add("Sanders tweet 1")
        sandersTweets.add("Sanders tweet 2")
        sandersTweets.add("Sanders tweet 3")
        sandersTweets.add("Sanders tweet 4")
        sandersTweets.add("Sanders tweet 5")

        tweetCandidateMap.put(presidentialCandidates[4], sandersTweets)

        return tweetCandidateMap
    }
}