package com.example.notemvvmapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;

import com.example.notemvvmapp.permsistance.modal.DateConvertor;
import com.example.notemvvmapp.permsistance.modal.Note;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters(DateConvertor.class)
public interface NoteDao {
    @Query("SELECT * FROM NOTE")
    LiveData<List<Note>> getAllNotes();

    @Insert(onConflict = REPLACE)
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);

}

