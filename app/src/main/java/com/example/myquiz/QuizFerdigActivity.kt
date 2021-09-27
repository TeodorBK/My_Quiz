package com.example.myquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class QuizFerdigActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_ferdig)

        /*dette er variablene med knappene og textveiw-ene man bruker*/
        val exitButton = findViewById<Button>(R.id.exitButton)

        val takkMelding = findViewById<TextView>(R.id.takkeMelding)
        val name = intent.getStringExtra("name")

        val resultatMelding = findViewById<TextView>(R.id.resultatMelding)
        val antallRiktige = intent.getStringExtra("riktige")
        val antallQuestions = intent.getStringExtra("mengdequestions")

        /*her skriver man ut en takke meldig med navnet og en resultat melding med resultatet*/
        takkMelding.text = "Takk for at du deltok i Quizen, ${name}!"
        resultatMelding.text = "${antallRiktige} av ${antallQuestions} riktige"

        /*dette er avslutnings knappen som avsluter appen*/
        exitButton.setOnClickListener {
            finishAffinity()
        }   
    }
}