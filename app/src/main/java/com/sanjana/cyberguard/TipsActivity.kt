package com.sanjana.cyberguard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sanjana.cyberguard.databinding.ActivityTipsBinding

class TipsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Display security tips using string resource
        binding.tipsTextView.text = getString(R.string.tips_content)
    }
}