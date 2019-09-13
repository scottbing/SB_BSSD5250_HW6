package com.example.sb_bssd5250_hw5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements NotesData.NotesDataUpdatedListener {

    private RecyclerView notesRV;

    @Override
    public void updateNotesDependents() {
        NotesAdapter notesAdapter = new NotesAdapter();
        notesRV.swapAdapter(notesAdapter, true);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        ArrayList<Note> notesArray = NotesData.getInstance(this).getNoteList();
        makeDummyData(30);

        NotesData.getInstance(this).setListener(this);

        notesRV = new RecyclerView( this);
        notesRV.setBackgroundColor(Color.RED);

        NotesAdapter notesAdapter = new NotesAdapter();
        notesAdapter.setmContext(this);
        notesRV.setAdapter(notesAdapter);
        notesRV.setLayoutManager(new LinearLayoutManager(this));

        setContentView(notesRV);

    }

    private void makeDummyData(int number) {
        for(int i=0; i<number; i++) {
            Note note = new Note();
            note.setName("Note " + String.valueOf(i));
            note.setDesc("Desc " + String.valueOf(i));
            NotesData.getInstance(this).getNoteList().add(note);
        }
    }
}
