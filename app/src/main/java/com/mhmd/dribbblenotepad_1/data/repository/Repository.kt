package com.mhmd.dribbblenotepad_1.data.repository

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import com.mhmd.dribbblenotepad_1.data.dao.NoteDao
import com.mhmd.dribbblenotepad_1.data.model.Note

class Repository(private val noteDao: NoteDao) {
    
    val allNotes: LiveData<List<Note>> = noteDao.getAll()
    fun insert(note: Note) {
        noteDao.insert(note)
    }
    
    fun update(note: Note) {
        noteDao.update(note)
    }
    
    fun delete(note: Note) {
        noteDao.delete(note)
    }
    
    fun deleteAll() {
        noteDao.deleteAll()
    }
}