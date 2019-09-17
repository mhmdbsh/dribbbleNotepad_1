package com.mhmd.dribbblenotepad_1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mhmd.dribbblenotepad_1.R
import com.mhmd.dribbblenotepad_1.ui.note.NoteFragment
import kotlinx.android.synthetic.main.fragment_home.*

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
        val imageMenu: ImageView = root.findViewById(R.id.image_menu)
        imageMenu.setOnClickListener {
        }
        val fab: FloatingActionButton = root.findViewById(R.id.fab_new_note)
        fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.go_to_note))
        return root
    }
}