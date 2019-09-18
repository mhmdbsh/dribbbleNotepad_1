package com.mhmd.dribbblenotepad_1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mhmd.dribbblenotepad_1.data.dao.NoteDao
import com.mhmd.dribbblenotepad_1.data.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    
    companion object {
        fun getInstance(context: Context): NoteDatabase =
            Room.databaseBuilder(
                context.applicationContext, NoteDatabase::class.java,
                "note_database"
            ).build()
    }
    
    abstract fun noteDao(): NoteDao
    
}

object NoteDatabaseProvider {
    private var noteDatabase: NoteDatabase? = null
    fun getInstance(context: Context): NoteDatabase {
        if (noteDatabase == null) {
            noteDatabase = NoteDatabase.getInstance(context)
        }
        return noteDatabase!!
    }
    
}