package com.mhmd.dribbblenotepad_1.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String = "",
    val body: String = "",
    val date: String = "",
    val color: Int = 0
)