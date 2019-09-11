package com.example.sb_bssd5250_hw5;

import android.content.Context;

import java.util.ArrayList;

public class NotesData {  //Singleton class of all not data

    private ArrayList<Note> mNotes;

    private static NotesData sNotesData;
    private Context mAppContext;

    private NotesData(Context context) {
        mAppContext = context;
        mNotes = new ArrayList<Note>();
    }

    public ArrayList<Note> getNoteList() {
        return mNotes;
    }

    public static NotesData getInstance(Context c) {
        if (sNotesData == null) {
            sNotesData = new NotesData(c.getApplicationContext());
        }
        return sNotesData;
    }
}
