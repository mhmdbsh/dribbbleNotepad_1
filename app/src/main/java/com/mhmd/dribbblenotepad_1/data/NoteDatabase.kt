package com.mhmd.dribbblenotepad_1.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mhmd.dribbblenotepad_1.data.dao.NoteDao
import com.mhmd.dribbblenotepad_1.data.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    
    abstract fun noteDao(): NoteDao
    
    
}

