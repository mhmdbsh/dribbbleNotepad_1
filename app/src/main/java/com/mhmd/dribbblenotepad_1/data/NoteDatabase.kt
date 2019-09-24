package com.mhmd.dribbblenotepad_1.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    
    abstract fun noteDao(): NoteDao
    
    companion object {
        var INSTANCE: NoteDatabase? = null
        
        fun geNoteDatabase(context: Context): NoteDatabase? {
            if (INSTANCE == null) {
                synchronized(NoteDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java, "note_database"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}

