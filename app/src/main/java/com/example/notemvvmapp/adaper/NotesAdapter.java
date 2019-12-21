package com.example.notemvvmapp.adaper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemvvmapp.R;
import com.example.notemvvmapp.permsistance.modal.Note;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {
    private List<Note> noteList;

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public NotesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_list_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(String.valueOf(noteList.get(position).getNoteTitle()));
        holder.tvDesc.setText(String.valueOf(noteList.get(position).getNoteDesc()));
        holder.tvCreateAt.setText(new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss", Locale.ENGLISH).format(noteList.get(position).getCreatedAt().getTime()));
    }

    @Override
    public int getItemCount() {
        return noteList == null ? 0 : noteList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDesc, tvCreateAt;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.noteTitle);
            tvDesc = itemView.findViewById(R.id.noteDescription);
            tvCreateAt = itemView.findViewById(R.id.createdAt);

        }
    }
}
