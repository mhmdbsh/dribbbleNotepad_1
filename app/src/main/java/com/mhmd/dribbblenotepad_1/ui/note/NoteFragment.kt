package com.mhmd.dribbblenotepad_1.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mhmd.dribbblenotepad_1.R

class NoteFragment : Fragment() {
    
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_note, container, false)
        
        val imageBack: ImageView = root.findViewById(R.id.image_back)
        imageBack.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.go_to_home))
        return root
    }
    
}
