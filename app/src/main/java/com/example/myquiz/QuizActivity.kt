package com.example.myquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_main.*

class QuizActivity : AppCompatActivity() {

    /*dette er listene over spørsmålene og en liste over svarene*/
    private val listeOverQuestions : Array<String> = arrayOf("'Crocodile Rock' er en Elton Johnlåt",
        "Strutser kan fly",
        "Moskusdyr finnes i Norge",
        "Giraffer kan bli over fire meter",
        "Rognebær er giftige")
    private val listeOverSvar : Array<Boolean> = arrayOf(true, false, true, true, false)


    /*her er variablene man bruker for å holde telling på hvor mange spørsmål det er, og en som holder
    * telling på hvem spørsmål brukeren er på*/
    private var antallQuestions : Int = 0
    private var nesteQuestion : Int = 0

    /*dette er en variabel med svaret som er i boolean for at det skal være true eller false, og en
    * variabel som holder tellingen på antall riktige svar*/
    private var svar : Boolean = false
    private var score : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        /*her tar man inn navnet brukeren legger inn på den forrige siden*/
        val name = intent.getStringExtra("name")
        val names = name.toString()

        /*dette er der man tar inn alle knapper som blir brukt og lagrer dem i en variabel*/
        val svarTrue = findViewById<Button>(R.id.svarNr1)
        val svarFalse = findViewById<Button>(R.id.svarNr2)

        /*dette er der man tar inn alle TextView-ene som blir brukt og lagrer dem i en variabel*/
        val questions = findViewById<TextView>(R.id.questions)
        val antall = findViewById<TextView>(R.id.antallSpørsmål)


        /*her har man en for loop som gør gjennom arrayen med spørsmål for å se hvor mange spørsmål det er*/
        for (questionmengde in listeOverQuestions) {
            antallQuestions++
        }

        /*dette er her man printer det første spørsmålet og hvilket spørsmål man er på*/
        questions.text = "${listeOverQuestions[0]}"
        antall.text = "Spørsmål: ${nesteQuestion + 1}/${antallQuestions}"

        /*her er onClickListener-en til true knappen som setter svaret til true og sender svaret,
        * 'spørsmål textView-en' og 'antall spørsmål textVeiw-en' til en funksjon lengre ned*/
        svarTrue.setOnClickListener {
            svar = true
            sjekkSvar(svar, names, questions, antall)
        }

        /*her er onClickListener-en til false knappen som setter svaret til true og sender svaret,
        * 'spørsmål textView-en' og 'antall spørsmål textVeiw-en' til en funksjon lengre ned*/
        svarFalse.setOnClickListener {
            svar = false
            sjekkSvar(svar, names, questions, antall)
        }
    }

    /*dette er funksjonen som tar inn all informasjonen som kommer når man trykker på true eller false knappen
    * den bruker den informasjonen for å se om brukeren har trykket riktig eller feil*/
    fun sjekkSvar(svaret : Boolean, name : String, question : TextView, antall : TextView) {

        /*dette er en if statment som ser om brukeren har tryket riktig eller feil. den gjør det med å se om
        * brukerens svaret er lik det svaret i svarListen som er satt på det spørsmålet brukeren er på*/
        if (svaret == listeOverSvar[nesteQuestion]) {
            score++
            Toast.makeText(this, "Riktig :)", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Feil :(", Toast.LENGTH_SHORT).show()
        }

        /*denne plusser 1 på variablen som holder telling på hvem spørsmål man er på sånn at den går til neste spørsmål*/
        nesteQuestion++

        /*her er det en if statement som ser om variablen som holder telling på hvem spørsmål man er
        * på  er på det siste spørsmålet. og hvis det er sant/true avsluter quiz siden og sender brukeren
        * til resultatsiden, hvis ikke printer den det neste spørsmålet og hvilket spørsmål man er på*/
        if (nesteQuestion == antallQuestions) {
            val riktigeSvar = score.toString()
            val questionMengde = antallQuestions.toString()
            val mIntent = Intent(this@QuizActivity,QuizFerdigActivity::class.java)

            /*her sender man navnet man skrev inn på forrige side, hvor mange riktige svar og hvor mange
            * spørsmål det var til resultat siden*/
            mIntent.putExtra("name", name)
            mIntent.putExtra("riktige", riktigeSvar)
            mIntent.putExtra("mengdequestions", questionMengde)
            startActivity(mIntent)
            finish()
        } else {
            question.text = "${listeOverQuestions[nesteQuestion]}"
            antall.text = "Spørsmål: ${nesteQuestion + 1}/${antallQuestions}"
        }
    }
}