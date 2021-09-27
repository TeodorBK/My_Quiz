package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*dette lagrer man knappen som starter quizen i en variabel*/
        val startButton = findViewById<Button>(R.id.startButton)
        val navn : EditText= findViewById<EditText>(R.id.navn)

        /*dette er en OnClickListener som starter quizen*/
        startButton.setOnClickListener {

            /*her lagrer man navnet*/
            val name = navn.text.toString()

            /*her ser man om brukeren har lagt inn et navn eller ikke*/
            /*hvis de ikke har det får de ikke starta quizen og får en beskje om at de må legge inn et navn*/
            /*hvis de har lagt inn et navn starter quizen og navnet blir sendt vidre*/
            if (navn.text.toString() == "") {
                Toast.makeText(this, "Legg inn et navn", Toast.LENGTH_SHORT).show()
            } else {
                val mIntent = Intent(this@MainActivity,QuizActivity::class.java)
                mIntent.putExtra("name", name)
                startActivity(mIntent)
            }
        }
    }

}