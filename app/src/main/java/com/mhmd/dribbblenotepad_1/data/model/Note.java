package com.mhmd.dribbblenotepad_1.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    int id;
    String title;
    String body;
    String date;
    int color;

    public Note(String title, String body, String date, int color) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }

    public int getColor() {
        return color;
    }
}
