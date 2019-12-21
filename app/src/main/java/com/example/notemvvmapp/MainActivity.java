package com.example.notemvvmapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemvvmapp.adaper.NotesAdapter;
import com.example.notemvvmapp.permsistance.modal.Note;
import com.example.notemvvmapp.permsistance.viewmodal.NotesListViewModal;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    NotesAdapter notesAdaper;
    NotesListViewModal viewModalNote;
    EditText etTitle, etDesc;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModalNote = ViewModelProviders.of(this).get(NotesListViewModal.class);

        etTitle = findViewById(R.id.et_title);
        etDesc = findViewById(R.id.et_desc);
        btnAdd = findViewById(R.id.btnAddNote);

        mRecyclerView = findViewById(R.id.recyclerViewNotes);
        notesAdaper = new NotesAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etTitle.getText().toString().isEmpty() && !etDesc.getText().toString().isEmpty())
                    viewModalNote.addNotes(new Note(etTitle.getText().toString(), etDesc.getText().toString(), new Date()));
            }
        });

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        viewModalNote.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                Log.i("KTZ", notes.toString());
                mRecyclerView.setAdapter(notesAdaper);
                notesAdaper.setNoteList(notes);
                notesAdaper.notifyDataSetChanged();
            }
        });

    }
}
