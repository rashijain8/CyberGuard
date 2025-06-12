package com.sanjana.cyberguard

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HabitTrackerActivity : AppCompatActivity() {

    private lateinit var cbChangePassword: CheckBox
    private lateinit var cbEnable2FA: CheckBox
    private lateinit var cbAvoidPublicWiFi: CheckBox
    private lateinit var cbUpdateSoftware: CheckBox
    private lateinit var cbCheckAppPermissions: CheckBox
    private lateinit var btnSaveHabits: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit_tracker)

        cbChangePassword = findViewById(R.id.cbChangePassword)
        cbEnable2FA = findViewById(R.id.cbEnable2FA)
        cbAvoidPublicWiFi = findViewById(R.id.cbAvoidPublicWiFi)
        cbUpdateSoftware = findViewById(R.id.cbUpdateSoftware)
        cbCheckAppPermissions = findViewById(R.id.cbCheckAppPermissions)
        btnSaveHabits = findViewById(R.id.btnSaveHabits)

        loadHabitProgress()

        btnSaveHabits.setOnClickListener {
            saveHabitProgress()
            Toast.makeText(this, "Habit progress saved!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveHabitProgress() {
        val sharedPreferences = getSharedPreferences("CyberHabits", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putBoolean("ChangePassword", cbChangePassword.isChecked)
        editor.putBoolean("Enable2FA", cbEnable2FA.isChecked)
        editor.putBoolean("AvoidPublicWiFi", cbAvoidPublicWiFi.isChecked)
        editor.putBoolean("UpdateSoftware", cbUpdateSoftware.isChecked)
        editor.putBoolean("CheckAppPermissions", cbCheckAppPermissions.isChecked)

        editor.apply()
    }

    private fun loadHabitProgress() {
        val sharedPreferences = getSharedPreferences("CyberHabits", Context.MODE_PRIVATE)

        cbChangePassword.isChecked = sharedPreferences.getBoolean("ChangePassword", false)
        cbEnable2FA.isChecked = sharedPreferences.getBoolean("Enable2FA", false)
        cbAvoidPublicWiFi.isChecked = sharedPreferences.getBoolean("AvoidPublicWiFi", false)
        cbUpdateSoftware.isChecked = sharedPreferences.getBoolean("UpdateSoftware", false)
        cbCheckAppPermissions.isChecked = sharedPreferences.getBoolean("CheckAppPermissions", false)
    }
}
