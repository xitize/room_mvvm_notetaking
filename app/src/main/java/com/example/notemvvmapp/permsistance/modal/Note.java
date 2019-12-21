package com.example.notemvvmapp.permsistance.modal;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String noteTitle;
    private String noteDesc;

    @TypeConverters(DateConvertor.class)
    private Date createdAt;

    public Note(String noteTitle, String noteDesc, Date createdAt) {
        this.noteTitle = noteTitle;
        this.noteDesc = noteDesc;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDesc() {
        return noteDesc;
    }

    public void setNoteDesc(String noteDesc) {
        this.noteDesc = noteDesc;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteDesc='" + noteDesc + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
