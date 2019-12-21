package com.example.notemvvmapp.permsistance.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.notemvvmapp.NoteDao;
import com.example.notemvvmapp.permsistance.NoteDatabase;
import com.example.notemvvmapp.permsistance.modal.Note;

import java.util.List;

public class NotesRepository {
    private LiveData<List<Note>> getAllNotes;
    private NoteDao noteDao;

    public NotesRepository(Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getNoteDatabase(application);
        noteDao = noteDatabase.noteDao();
        getAllNotes = noteDao.getAllNotes();
    }

    public LiveData<List<Note>> getGetAllNotes() {
        return getAllNotes;
    }

    public void addNotes(Note note) {
        // noteDao.insertNote(note);
        new AddNote().execute(note);
    }

    public class AddNote extends AsyncTask<Note, Void, Void> {
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insertNote(notes[0]);
            return null;
        }
    }


}
