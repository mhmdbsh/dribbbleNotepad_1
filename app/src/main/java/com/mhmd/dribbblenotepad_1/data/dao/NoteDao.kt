package com.mhmd.dribbblenotepad_1.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mhmd.dribbblenotepad_1.data.model.Note

@Dao
interface NoteDao {
    
    @Insert
    fun insert(note: Note)
    
    @Update
    fun update(note: Note)
    
    @Delete
    fun delete(note: Note)
    
    @Query("SELECT * FROM note_table")
    fun getAll(): LiveData<List<Note>>
    
    @Query("DELETE FROM note_table")
    fun deleteAll()
    
}