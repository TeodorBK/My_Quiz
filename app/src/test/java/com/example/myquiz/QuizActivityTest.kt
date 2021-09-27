package com.example.myquiz

import android.widget.TextView
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)

class QuizActivityTest {
    @Test

    fun WhenImportIsValid() {
        val svar = true
        val name = "Tim"
        val test: QuizActivity = QuizActivity()
        val text1: TextView = TextView(test)
        val text2: TextView = TextView(test)


        val result = test.sjekkSvar(svar, name, text1, text2)

        assertThat(result).isEqualTo(true)
    }
}
