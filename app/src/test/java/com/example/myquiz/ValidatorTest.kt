package com.example.myquiz

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)

class ValidatorTest {
    @Test

    fun whenImportIsValid(){
        val amount = 1

        val desc = "S"

        val result = Validator.validatorInput(amount, desc)

        assertThat(result).isEqualTo(true)
    }

}