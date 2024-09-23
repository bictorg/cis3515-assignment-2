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

    private EditText nameInput, emailInput, passwordInput, confirmPasswordInput;
    private Spinner programSpinner;
    private TextView welcomeMessage;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        programSpinner = findViewById(R.id.programSpinner);
        welcomeMessage = findViewById(R.id.welcomeMessage);
        saveButton = findViewById(R.id.saveButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.programs_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        programSpinner.setAdapter(adapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
            }
        });
    }

    private void saveUserData() {
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String confirmPassword = confirmPasswordInput.getText().toString();
        String program = programSpinner.getSelectedItem().toString();

        if (name.isEmpty()) {
            nameInput.setError("Name is required");
            return;
        }

        if (email.isEmpty()) {
            emailInput.setError("Email is required");
            return;
        }

        if (program.equals("Please select your program")) {
            Toast.makeText(this, "Please select a program", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            passwordInput.setError("Password is required");
            return;
        }

        if (!password.equals(confirmPassword)) {
            confirmPasswordInput.setError("Passwords do not match");
            return;
        }

        welcomeMessage.setText("Welcome, " + name + ", to the SignUpForm App");
    }
}