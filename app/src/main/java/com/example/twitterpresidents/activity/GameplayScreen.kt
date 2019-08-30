package com.example.twitterpresidents.activity

import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.twitterpresidents.R
import com.example.twitterpresidents.adapter.CandidateChoiceListAdapter
import com.example.twitterpresidents.fragments.*
import com.example.twitterpresidents.model.PresidentialCandidate
import com.example.twitterpresidents.util.PresidentialCandidatesData
import kotlinx.android.synthetic.main.activity_gameplay_screen.*
import java.util.*

//user selects who made the tweet.
//composed of top portion which includes a lot of ui elements and the tweet in a custom view
//bottom part is the recycler view of the candidate choices.

class GameplayScreen : AppCompatActivity(), Lifebar.OnFragmentInteractionListener, Progressbar.OnFragmentInteractionListener {

//    val presidentialList = mutableListOf<PresidentialCandidate>()
    lateinit var candidateListAdapter : CandidateChoiceListAdapter
    lateinit var candidateSelectionList : MutableList<PresidentialCandidate>
    lateinit var playerProgressFragment : MultiplayerFragment

    companion object {
        var correctAnswer : Int = -1 //randomly generates which selection is correct.
        get(){
            val guess = (0..2).random()
            Log.i("GUESS: ", "${guess}")
            return guess
        }

        var aiResponse : Int = -1 //the AI's guess
        get(){
            return (0..2).random()
        }

        lateinit var soundPool : SoundPool
        lateinit var presCandidates : PresidentialCandidatesData
        var isMultiplayer : Boolean? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay_screen)

        isMultiplayer = intent.getBooleanExtra("IS_MULTIPLAYER", false)

        isMultiplayer?.let {
            if(it){ //if its multiplayer, add another fragment
                playerProgressFragment = MultiplayerFragment()
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.container_for_fragments, playerProgressFragment)
                fragmentTransaction.commit()
            }
        }

        //setup sound effects for right or wrong answers
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build()

            soundPool = SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build()
        } else{
            soundPool = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        }

        //setup recyclerview of candidates
        presCandidates = PresidentialCandidatesData()

        candidateListAdapter = CandidateChoiceListAdapter(presCandidates.presidentialCandidates,
                this, soundPool.load(this, R.raw.correct_sound, 1),
                soundPool.load(this, R.raw.wrong_sound, 1))

        candidate_choices.setHasFixedSize(true)
        candidate_choices.adapter = candidateListAdapter
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        candidate_choices.layoutManager = manager
    }

    override fun noMoreLives() {
        val gameOverFragment = GameOverScreen()
        val fragmentActivity = this as FragmentActivity
        val fragManager = fragmentActivity.supportFragmentManager
        gameOverFragment.show(fragManager, "frag_k")
    }

    override fun progressbarMaximized() {
        //go to victory screen
        val intent = Intent(this, VictoryScreen::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
//        val end_game_btn = (tweet_options_bar.childFragmentManager.findFragmentById(R.id.end_game)) as Button?
//        end_game_btn?.performClick()
    }

    //chooses a random presidential candidate to create tweets, sets tweet in display, returns that presidential candidate
    fun chooseRandomCandidate() : PresidentialCandidate {
        val candChoice = (0..presCandidates.candidateTweets.size-1).random()
        val candidateChoice : PresidentialCandidate = presCandidates.presidentialCandidates[candChoice]
        val listOfTweets : MutableList<String>? = presCandidates.candidateTweets[candidateChoice]

        listOfTweets?.let{
            val size : Int = it.size
            val selection : Int = (0..size-1).random()

            val tweet : String = it[selection]
            val fragment = supportFragmentManager.findFragmentById(R.id.tweet_display)
            (fragment?.view?.findViewById(R.id.tweet) as TextView).text = tweet

            it.removeAt(selection) //removes tweet from database of tweets
        }

        return candidateChoice
    }

    //given that one of the displays has to be the correct candidate
    fun chooseCandidateSelection(chosenCorrectAnswer : PresidentialCandidate) {
        candidateSelectionList.add(chosenCorrectAnswer)

        //choose 2 other random presidential candidates from the list
        
    }
}
