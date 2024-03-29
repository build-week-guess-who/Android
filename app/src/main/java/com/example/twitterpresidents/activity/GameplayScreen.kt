package com.example.twitterpresidents.activity

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.net.rtp.AudioStream
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.twitterpresidents.R
import com.example.twitterpresidents.adapter.CandidateChoiceListAdapter
import com.example.twitterpresidents.fragments.Lifebar
import com.example.twitterpresidents.fragments.Progressbar
import com.example.twitterpresidents.model.PresidentialCandidate
import kotlinx.android.synthetic.main.activity_gameplay_screen.*

//user selects who made the tweet.
//composed of top portion which includes a lot of ui elements and the tweet in a custom view
//bottom part is the recycler view of the candidate choices.

class GameplayScreen : AppCompatActivity(){

    companion object {
        val presidentialList = mutableListOf<PresidentialCandidate>()
        val candidateListAdapter = CandidateChoiceListAdapter(presidentialList)
        var correctAnswer : Int = -1 //randomly generates which selection is correct.
        get(){
            return (0..3).random()
        }
        var correctSound : Int? = null
        var wrongSound : Int? = null
        var soundPool : SoundPool? = null
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

        correctSound = soundPool?.load(this, R.raw.correct_sound, 1)
        wrongSound = soundPool?.load(this, R.raw.wrong_sound, 1)
    }
}
