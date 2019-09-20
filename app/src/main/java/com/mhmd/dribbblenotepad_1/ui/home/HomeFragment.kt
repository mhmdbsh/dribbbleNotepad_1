package com.mhmd.dribbblenotepad_1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mhmd.dribbblenotepad_1.R
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    
    private lateinit var homeViewModel: HomeViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        
        val dateTextView: TextView = root.findViewById(R.id.home_date)
        dateTextView.text = SimpleDateFormat("MMM - dd", Locale.getDefault()).format(Date())
        
        val calendar = Calendar.getInstance()
        val weekDayTextView: TextView = root.findViewById(R.id.home_week_day)
        weekDayTextView.text =
            calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
        
        val imageMenu: ImageView = root.findViewById(R.id.image_menu)
        imageMenu.setOnClickListener {
        }
        val fab: FloatingActionButton = root.findViewById(R.id.fab_new_note)
        fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.go_to_note))
        return root
    }
}