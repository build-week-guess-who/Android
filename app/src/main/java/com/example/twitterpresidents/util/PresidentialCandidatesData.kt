package com.example.twitterpresidents.util

import com.example.twitterpresidents.R
import com.example.twitterpresidents.model.PresidentialCandidate

class PresidentialCandidatesData {

    lateinit var presidentialCandidates : MutableList<PresidentialCandidate>
    lateinit var candidateTweets : MutableMap<PresidentialCandidate, MutableList<String>>

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
        trumpTweets.add("The Media is destroying the Free Press! Mark Levin. So True!")
        trumpTweets.add("The Dow is down 573 points perhaps on the news that Representative Seth Moulton, whoever that may be, has dropped out of the 2020 Presidential Race!")
        trumpTweets.add("....My only question is, who is our bigger enemy, Jay Powell or Chairman Xi?")
        trumpTweets.add("A sad day for the Democrats, Kirsten Gillibrand has dropped out of the Presidential Primary. I’m glad they never found out that she was the one I was really afraid of!")
        trumpTweets.add("Another totally Fake story in the Amazon Washington Post (lobbyist) which states that if my Aides broke the law to build the Wall (which is going up rapidly), I would give them a Pardon. This was made up by the Washington Post only in order to demean and disparage - FAKE NEWS!")

        tweetCandidateMap.put(presidentialCandidates[0], trumpTweets)

        val harrisTweets = mutableListOf<String>()
        harrisTweets.add("Inclusive employment for Americans with disabilities remains one of the unfulfilled promises of the ADA and the fight to ensure civil rights for people with disabilities. I’m committed to changing that as president.")
        harrisTweets.add("Pharmaceutical companies have long been in the business of prioritizing profit over public health. No one should be up at 3AM worrying how they'll pay for their prescription drugs. That will change when I’m president. These drug companies must set fair prices—or pay the price.")
        harrisTweets.add("Donald Trump is dangling pardons for subordinates who would break the law to build his vanity project on the southern border. Let's be honest here: Trump is a lawless president.")
        harrisTweets.add("On the anniversary of the March on Washington we remember a Dream not yet fulfilled and the voices that must be heard. We must continue this fight for jobs, equality, the right to vote, and freedom. We stand on the shoulders of a legacy that forever reminds us we shall overcome.")
        harrisTweets.add("Because of high housing costs, over half of South Carolina renters come up short on their basic needs — like putting food on the table and paying for gas. My Rent Relief Act would help ease the housing crisis in our nation.")

        tweetCandidateMap.put(presidentialCandidates[1], harrisTweets)

        val yangTweets = mutableListOf<String>()
        yangTweets.add("You know what would be a great idea - a global climate change mitigation force. Countries would contribute according to their GDP.  There are a lot of issues out there in places that don’t fall neatly in any one country’s territory.")
        yangTweets.add("Technically there is no official dress code for the debates.")
        yangTweets.add("Quantum computers may make our current encryption standards ineffective and obsolete. We should invest in new ones that will work even as new technologies are developed. You know what would help make Americans healthier?  Better food and nutrition.")
        yangTweets.add("Bernie ignores the facts that money in our hands would 1) create hundreds of thousands of local jobs and 2) recognize and reward the nurturing work being done in our homes and communities every day.  He also assumes that everyone wants to work for the government which isn’t true.")

        tweetCandidateMap.put(presidentialCandidates[2], yangTweets)

        val warrenTweets = mutableListOf<String>()
        warrenTweets.add("How candidates fund their campaigns matters. Ours has been 100% grassroots-funded since the beginning. No PACs or closed-door meetings with millionaires or CEOs—just people like you chipping in what they can. Will you donate 3 and join the movement?")
        warrenTweets.add("Big internet service providers have excluded millions of families from fast, reliable internet access in order to maximize their profits. I've got a plan to fix that.")
        warrenTweets.add("I don’t want a government that works for giant corporations. I want one that works for our families.")
        warrenTweets.add("Donald Trump is a walking, talking conflict of interest. No president should be allowed to push the rules of our government to benefit their personal bottom line. My anti-corruption bill—the biggest since Watergate—tackles this kind of corruption head on.")
        warrenTweets.add("Two years ago the Burmese military began a campaign that killed thousands of Rohingya and forced over 700,000 people to flee their homes. Today and every day we must stand up for the Rohingya, for reconciliation and  accountability in Burma, and for human rights around the world.")

        tweetCandidateMap.put(presidentialCandidates[3], warrenTweets)

        val sandersTweets = mutableListOf<String>()
        sandersTweets.add("The Amazon is being destroyed. So Trump opens America's largest rainforest, Tongass National Forest, to logging and mining. Methane emissions surge worldwide. Trump's EPA will make them grow faster.The president and his billionaire friends are a threat to our entire planet.")
        sandersTweets.add("We must legalize marijuana nationwide and expunge past convictions.")
        sandersTweets.add("It is crazy that we are the only country that lets drug companies charge anything they want—even 6 million—and raise the price tomorrow. Taxpayers give Big Pharma patent monopolies, tax breaks and research money. But Medicare isn't allowed to negotiate fair prices. Shameful.")
        sandersTweets.add("What does it mean when the function of the health care system—in the richest country in the history of the world—is to make billions for insurance and drug companies? 18 percent of Americans with diabetes are rationing the medications they need to live.")
        sandersTweets.add("Under my legislation, the Opioid Crisis Accountability Act, Johnson & Johnson would be fined \$7.8 billion—13 times as much as this penalty, about half of the company's profits, and 10 percent of the total annual cost of the terrible opioid crisis afflicting our country.")

        tweetCandidateMap.put(presidentialCandidates[4], sandersTweets)

        return tweetCandidateMap
    }
}