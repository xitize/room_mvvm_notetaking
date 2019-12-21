package com.example.notemvvmapp.permsistance;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notemvvmapp.NoteDao;
import com.example.notemvvmapp.permsistance.modal.Note;

@Database(entities = Note.class, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase noteDatabase;

    public static NoteDatabase getNoteDatabase(Context context) {
        if (noteDatabase == null) {
            noteDatabase = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note_database").build();
        }
        return noteDatabase;
    }

    public static void closeDatabase() {
        noteDatabase = null;
    }

    public abstract NoteDao noteDao();
}
