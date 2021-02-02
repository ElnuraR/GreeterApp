package com.example.greeter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String GAME_STATE_KEY = "state";

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recovering the instance state
        if (savedInstanceState != null) {
            name = savedInstanceState.getString(GAME_STATE_KEY);
            displayGreeting(name);
        }
    }

    private void displayGreeting(String name) {
        TextView greetingTextView = findViewById(R.id.greeting);
        greetingTextView.setText("Hello, " + name);
    }

    public void submitName(View view) {
        EditText nameField = findViewById(R.id.name);
        name = nameField.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, "Name field can not be empty", Toast.LENGTH_SHORT).show();
        }

        displayGreeting(name);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(GAME_STATE_KEY, name);
    }
}