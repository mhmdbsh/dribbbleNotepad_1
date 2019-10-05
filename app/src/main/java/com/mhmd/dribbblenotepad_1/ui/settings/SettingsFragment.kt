package com.mhmd.dribbblenotepad_1.ui.settings

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mhmd.dribbblenotepad_1.MainActivity
import com.mhmd.dribbblenotepad_1.R
import java.util.*
import kotlin.concurrent.timerTask

class SettingsFragment : Fragment() {
    
    private lateinit var settingsViewModel: SettingsViewModel
    private lateinit var darkModeSwitch: Switch
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        
        val sharedPreferences = activity!!.getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        
        
        darkModeSwitch = root.findViewById(R.id.switch_dark_mode)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            darkModeSwitch.isChecked = true
        
        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editor.putBoolean("IS_DARK_MODE", true)
            } else {
                editor.putBoolean("IS_DARK_MODE", false)
            }
            editor.apply()
            Timer().schedule(timerTask {
                restart()
            },250)
        }
        
        return root
    }
    
    private fun restart() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }
    
}