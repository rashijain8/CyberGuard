package com.sanjana.cyberguard


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sanjana.cyberguard.databinding.ActivityModulesBinding


class ModulesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityModulesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModulesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Display module content using string resource
        binding.moduleTextView.text = getString(R.string.module_content)
    }
}
