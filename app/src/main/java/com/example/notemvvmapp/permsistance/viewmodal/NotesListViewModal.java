package com.example.notemvvmapp.permsistance.viewmodal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notemvvmapp.permsistance.modal.Note;
import com.example.notemvvmapp.permsistance.repository.NotesRepository;

import java.util.List;

public class NotesListViewModal extends AndroidViewModel {
    private LiveData<List<Note>> mAllNotes;
    private NotesRepository notesRepository;


    public NotesListViewModal(@NonNull Application application) {
        super(application);
        notesRepository = new NotesRepository(application);
        mAllNotes = notesRepository.getGetAllNotes();
    }


    public LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }


    public void addNotes(Note note) {
        notesRepository.addNotes(note);
    }
}
