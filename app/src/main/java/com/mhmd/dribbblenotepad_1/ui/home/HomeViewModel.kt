package com.mhmd.dribbblenotepad_1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mhmd.dribbblenotepad_1.data.Note
import com.mhmd.dribbblenotepad_1.data.NoteDatabase

class HomeViewModel : ViewModel() {
    
    private val database = NoteDatabase.INSTANCE
    private val list = database!!.noteDao().getAll()
    
    public fun getAllNotes(): LiveData<List<Note>> {
        return list
    }
    
    
}