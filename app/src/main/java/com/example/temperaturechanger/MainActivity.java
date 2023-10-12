package com.example.temperaturechanger;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button cToFButton = findViewById(R.id.cToFButton);
        Button fToCButton = findViewById(R.id.fToCButton);

        cToFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCelsiusToFahrenheit();
            }
        });

        fToCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFahrenheitToCelsius();
            }
        });
    }

    private void convertCelsiusToFahrenheit() {
        try {
            double celsius = Double.parseDouble(inputEditText.getText().toString());
            double fahrenheit = (celsius * 9 / 5) + 32;
            resultTextView.setText("Temperature in Fahrenheit: " + fahrenheit);
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input. Please enter a number.");
        }
    }

    private void convertFahrenheitToCelsius() {
        try {
            double fahrenheit = Double.parseDouble(inputEditText.getText().toString());
            double celsius = (fahrenheit - 32) * 5 / 9;
            resultTextView.setText("Temperature in Celsius: " + celsius);
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input. Please enter a number.");
        }
    }
}