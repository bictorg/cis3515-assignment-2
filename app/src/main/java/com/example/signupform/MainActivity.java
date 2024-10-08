package com.example.signupform;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Spinner programSpinner;
    private Button saveButton;
    private TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        programSpinner = findViewById(R.id.programSpinner);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        saveButton = findViewById(R.id.saveButton);
        welcomeMessage = findViewById(R.id.welcomeMessage);

        // Set up the Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.program_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        programSpinner.setAdapter(adapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    displayWelcomeMessage();
                }
            }
        });
    }

    private boolean validateInput() {
        boolean isValid = true;

        // Validate name
        if (nameEditText.getText().toString().trim().isEmpty()) {
            nameEditText.setError("Name is required");
            isValid = false;
        }

        // Validate email
        if (emailEditText.getText().toString().trim().isEmpty()) {
            emailEditText.setError("Email is required");
            isValid = false;
        }

        // Validate program selection
        if (programSpinner.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "Please select a program", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        // Validate password
        if (passwordEditText.getText().toString().trim().isEmpty()) {
            passwordEditText.setError("Password is required");
            isValid = false;
        }

        // Validate password confirmation
        if (confirmPasswordEditText.getText().toString().trim().isEmpty()) {
            confirmPasswordEditText.setError("Password confirmation is required");
            isValid = false;
        } else if (!passwordEditText.getText().toString().equals(confirmPasswordEditText.getText().toString())) {
            confirmPasswordEditText.setError("Passwords do not match");
            isValid = false;
        }

        return isValid;
    }

    private void displayWelcomeMessage() {
        String name = nameEditText.getText().toString().trim();
        welcomeMessage.setText("Welcome, " + name + ", to the SignUpForm App");
        welcomeMessage.setVisibility(View.VISIBLE);
    }
}