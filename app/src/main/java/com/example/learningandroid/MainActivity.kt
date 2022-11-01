package com.example.learningandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        val startButton=findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener{
            startGame()
        }
        val nextButton=findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener{
            clickNext()
        }
    }

    private fun clickNext() {
        val inputText=findViewById<EditText>(R.id.inputText)
        val text=inputText.toString()
        val name=text.trim()
        if(name.length !in 1..9){
            val popup="Enter a valid name!"
            val toast= Toast.makeText(applicationContext,popup,Toast.LENGTH_SHORT)
            toast.show()
        }else{
            beginGame(name)
        }
    }

    private fun beginGame(name: String) {
        startActivity(Intent(this@MainActivity,GameActivity::class.java))
    }

    private fun startGame() {
        val startButton=findViewById<Button>(R.id.startButton)
        startButton.visibility= View.INVISIBLE
        val nextButton=findViewById<Button>(R.id.nextButton)
        val inputText=findViewById<EditText>(R.id.inputText)
        val onScreen= arrayOf(nextButton,inputText)
        for( elem in onScreen){
            elem.visibility=View.VISIBLE
        }
    }
}