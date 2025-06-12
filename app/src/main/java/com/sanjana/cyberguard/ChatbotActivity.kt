package com.sanjana.cyberguard

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ChatbotActivity : AppCompatActivity() {

    private lateinit var chatContainer: LinearLayout
    private lateinit var etUserInput: EditText
    private lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        chatContainer = findViewById(R.id.chatContainer)
        etUserInput = findViewById(R.id.etUserInput)
        btnSend = findViewById(R.id.btnSend)

        btnSend.setOnClickListener {
            val userMessage = etUserInput.text.toString()
            if (userMessage.isNotBlank()) {
                addMessage(userMessage, true)
                val botResponse = getBotResponse(userMessage)
                addMessage(botResponse, false)
                etUserInput.text.clear()
            }
        }
    }

    private fun addMessage(message: String, isUser: Boolean) {
        val textView = TextView(this)
        textView.text = message
        textView.textSize = 16f
        textView.setPadding(10, 10, 10, 10)

        if (isUser) {
            textView.setBackgroundResource(android.R.color.holo_blue_light)
        } else {
            textView.setBackgroundResource(android.R.color.holo_green_light)
        }

        chatContainer.addView(textView)
    }

    private fun getBotResponse(userInput: String): String {
        val responses = mapOf(
            "phishing" to "Phishing is a scam where attackers trick you into revealing personal info. Be cautious of links from unknown sources.",
            "hacked" to "Change your passwords, enable 2FA, and scan your device for malware if you suspect hacking.",
            "malware" to "Malware is malicious software. Avoid unknown downloads and keep your security software up to date.",
            "safe browsing" to "Use HTTPS websites, avoid clicking unknown links, and never save passwords on public computers.",
            "ransomware" to "Ransomware locks your files until you pay a ransom. Always back up your data and avoid suspicious links.",
            "password" to "Use strong passwords with a mix of letters, numbers, and symbols. Avoid using the same password for everything.",
            "2fa" to "Two-factor authentication adds an extra layer of security. Enable it wherever possible.",
            "public wifi" to "Avoid accessing sensitive accounts over public Wi-Fi. Use a VPN if necessary.",
            "antivirus" to "Antivirus software helps protect your device from threats. Keep it updated regularly.",
            "firewall" to "A firewall blocks unauthorized access. Keep it enabled for better security.",
            "updates" to "Regularly update your apps and OS to patch security vulnerabilities.",
            "spam" to "Spam emails may contain scams or malware. Never click on suspicious attachments or links.",
            "encryption" to "Encryption protects data by making it unreadable without a key. Use encrypted apps for messaging and storage."
        )

        return responses.entries.find { userInput.contains(it.key, ignoreCase = true) }?.value
            ?: "I'm not sure about that yet. Try asking about phishing, ransomware, or password safety!"
    }
}
