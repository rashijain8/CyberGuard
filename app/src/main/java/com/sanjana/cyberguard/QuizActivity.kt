package com.sanjana.cyberguard

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sanjana.cyberguard.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private val questions = listOf(
        "What is phishing?" to listOf("A fish species", "Cyber attack", "Programming language", "Security software"),
        "What does 2FA stand for?" to listOf("Two-Factor Authentication", "Two-Factor Attack", "File Access", "Data Encryption")
    )
    private val answers = listOf(1, 0)
    private var currentQuestion = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadQuestion()

        binding.submitButton.setOnClickListener {
            val selectedOption = binding.optionsGroup.checkedRadioButtonId
            if (selectedOption == -1) {
                Toast.makeText(this, "Select an answer!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val answerIndex = binding.optionsGroup.indexOfChild(findViewById(selectedOption))
            if (answerIndex == answers[currentQuestion]) score++

            if (currentQuestion < questions.size - 1) {
                currentQuestion++
                loadQuestion()
            } else {
                Toast.makeText(this, "Quiz Over! Score: $score/${questions.size}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loadQuestion() {
        binding.questionText.text = questions[currentQuestion].first
        val options = questions[currentQuestion].second
        binding.option1.text = options[0]
        binding.option2.text = options[1]
        binding.option3.text = options[2]
        binding.option4.text = options[3]
        binding.optionsGroup.clearCheck()
    }
}
