package com.example.pratapsandroidlab6;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare and initialize the variables
        TextView textview = findViewById(R.id.pwtv);
        EditText editpass = findViewById(R.id.editpw);
        Button button = findViewById(R.id.bt);

        // using the setOnClickListerner on
        // if password complexity is passed replace the textview variable with "The password meets the requirements."
        // if the password complexity is failed replace the text view variable with "The password requirement fail! TRY AGAIN"
        button.setOnClickListener(v -> {
            String password = editpass.getText().toString();
            if (checkPasswordComplexity(password)) {
                textview.setText("The password meets the requirements.");
            } else {
                textview.setText("The password requirement fail! TRY AGAIN");
            }
        });
    }

    /**
     * Checks if the password meets the complexity requirements.
     *
     * @param password the password string to check
     * @return true if the password meets all complexity requirements, false otherwise
     */
    public boolean checkPasswordComplexity(String password) {
        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(this, "Your password does not have an uppercase letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(this, "Your password does not have a lowercase letter", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(this, "Your password does not have a number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(this, "Your password does not have a special character", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if the character is one of the specified special characters.
     *
     * @param character the character to check
     * @return true if the character is a special character, false otherwise
     */
    public boolean isSpecialCharacter(char character) {
        switch (character) {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }
}
