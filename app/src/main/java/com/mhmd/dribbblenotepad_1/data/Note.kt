package com.mhmd.dribbblenotepad_1.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    val title: String = "",
    val body: String = "",
    val date: String = "",
    val color: Int

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    
}


