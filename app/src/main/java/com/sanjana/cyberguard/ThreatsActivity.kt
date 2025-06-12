package com.sanjana.cyberguard


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sanjana.cyberguard.databinding.ActivityThreatsBinding


class ThreatsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreatsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreatsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Display common cyber threats using string resource
        binding.threatsTextView.text = getString(R.string.threats_content)
    }
}
