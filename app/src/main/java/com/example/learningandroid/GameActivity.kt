package com.example.learningandroid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint

class GameActivity : AppCompatActivity() {
    var score=0
    var playerScore: TextView?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        playerScore=findViewById(R.id.scoreDisplay)
        playGame()

    }

    private fun playGame() {
        if(score>=10){
            startActivity(Intent(this@GameActivity,WinActivity::class.java))
        }else{
            val image=pickImage()
            clickable(image).start()
        }
    }

    private fun clickable(image: ImageButton): CountDownTimer {
        image.setOnClickListener {
            image.setImageResource(R.drawable.hit)
        }
        return object :CountDownTimer(1000,100){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                image.setImageResource(R.drawable.hole)
                image.setOnClickListener(null)
                playGame()
            }
        }
    }

    private fun pickImage(): ImageButton {
        val images=findViewById<ConstraintLayout>(R.id.game_layout).touchables
        images.shuffle()
        val randomImage=images[0] as ImageButton
        randomImage.setImageResource(R.drawable.mole)
        return randomImage
    }
}
