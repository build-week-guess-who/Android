package com.example.twitterpresidents.activity

import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.twitterpresidents.R
import com.example.twitterpresidents.adapter.CandidateChoiceListAdapter
import com.example.twitterpresidents.fragments.*
import com.example.twitterpresidents.util.PresidentialCandidatesData
import kotlinx.android.synthetic.main.activity_gameplay_screen.*

//user selects who made the tweet.
//composed of top portion which includes a lot of ui elements and the tweet in a custom view
//bottom part is the recycler view of the candidate choices.

class GameplayScreen : AppCompatActivity(), Lifebar.OnFragmentInteractionListener, Progressbar.OnFragmentInteractionListener {

//    val presidentialList = mutableListOf<PresidentialCandidate>()
    lateinit var candidateListAdapter : CandidateChoiceListAdapter
    lateinit var playerProgressFragment : MultiplayerFragment

    companion object {
        var correctAnswer : Int = -1 //randomly generates which selection is correct.
        get(){
            val guess = (0..3).random()
            Log.i("GUESS: ", "${guess}")
            return guess
        }

        var aiResponse : Int = -1 //the AI's guess
        get(){
            return (0..3).random()
        }

        lateinit var soundPool : SoundPool
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
        val presCandidates = PresidentialCandidatesData()
        candidateListAdapter = CandidateChoiceListAdapter(presCandidates.presidentialCandidates,
                this, soundPool.load(this, R.raw.correct_sound, 1),
                soundPool.load(this, R.raw.wrong_sound, 1))

        candidate_choices.setHasFixedSize(true)
        candidate_choices.adapter = candidateListAdapter
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        candidate_choices.layoutManager = manager

//        presidentialList.add(PresidentialCandidate(R.drawable.question_mark_outline, "Bernie Sanders", "@feelthebern"))
//        presidentialList.add(PresidentialCandidate(R.drawable.question_mark_outline, "Donald Trump", "@realdonaldtrump"))
//        presidentialList.add(PresidentialCandidate(R.drawable.question_mark_outline, "Kamala Harris", "@kamalaharris"))
//        candidateListAdapter.notifyDataSetChanged()

    }

    override fun noMoreLives() {
        Log.i("WEWLKJE0", "KJWHE")
        val gameOverFragment = GameOverScreen()
        val fragmentActivity = this as FragmentActivity
        val fragManager = fragmentActivity.supportFragmentManager
        gameOverFragment.show(fragManager, "frag_k")
    }

    override fun progressbarMaximized() {
        //go to victory screen
        val intent = Intent(this, ModeSelection::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
//        val end_game_btn = (tweet_options_bar.childFragmentManager.findFragmentById(R.id.end_game)) as Button?
//        end_game_btn?.performClick()
    }
}
