package com.example.hf2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_EDITTEXT = "editTextValue";
    private static final String KEY_CHECKBOX = "checkboxState";

    private EditText editText;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText_input);
        checkBox = findViewById(R.id.checkbox_status);

        if (savedInstanceState != null) {

            String savedText = savedInstanceState.getString(KEY_EDITTEXT);
            boolean savedCheckedState = savedInstanceState.getBoolean(KEY_CHECKBOX);


            if (savedText != null) {
                editText.setText(savedText);
            }
            checkBox.setChecked(savedCheckedState);
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {


        String inputText = editText.getText().toString();
        boolean isChecked = checkBox.isChecked();


        outState.putString(KEY_EDITTEXT, inputText);
        outState.putBoolean(KEY_CHECKBOX, isChecked);


        super.onSaveInstanceState(outState);
    }
}