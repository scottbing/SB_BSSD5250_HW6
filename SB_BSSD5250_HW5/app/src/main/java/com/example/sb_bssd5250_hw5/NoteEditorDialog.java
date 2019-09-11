package com.example.sb_bssd5250_hw5;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NoteEditorDialog extends DialogFragment {

    public static final String EXTRA_NAME = "com.example.sb_bssd5250_hw5a";
    public static final String EXTRA_DATE = "com.example.sb_bssd5250_hw5b";
    public static final String EXTRA_DESC = "com.example.sb_bssd5250_hw5c";

    private EditText nameText;
    private EditText dateText;
    private EditText descText;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);

        nameText = new EditText(getActivity());
        nameText.setHint("Enter Name");
        dateText = new EditText(getActivity());
        dateText.setHint("Enter Date");
        descText = new EditText(getActivity());
        descText.setHint("Enter Description");

        // this is taken from: https://stackoverflow.com/questions/12876624/multiple-edittext-objects-in-alertdialog
        LinearLayout alertLayout = new LinearLayout(getContext());
        alertLayout.setOrientation(LinearLayout.VERTICAL);
        alertLayout.setId(View.generateViewId());

        alertLayout.addView(nameText);
        alertLayout.addView(dateText);
        alertLayout.addView(descText);

        return new AlertDialog.Builder(getActivity())
                .setTitle("Modify Note")
                .setView(alertLayout)
                .setPositiveButton("Done", doneClickedListener)
                .setNegativeButton("Cancel", null)
                .create();

    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null) {
            // Target not set up, do nothing
        } else {
            Intent i = new Intent();
            i.putExtra( EXTRA_NAME, nameText.getText().toString());
            i.putExtra( EXTRA_DATE, dateText.getText().toString());
            i.putExtra( EXTRA_DESC, descText.getText().toString());
            getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
        }
    }

    private DialogInterface.OnClickListener doneClickedListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            //Log.d("noteEditorDialog", nameText.getText().toString());
            sendResult(Activity.RESULT_OK);
        }
    };
}
