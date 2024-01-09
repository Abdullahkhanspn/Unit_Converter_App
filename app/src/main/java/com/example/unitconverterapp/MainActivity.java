package com.example.unitconverterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private TextView weightTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weightEditText);
        Button calculateButton = findViewById(R.id.calculateButton);
        weightTextView = findViewById(R.id.weightTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertGramsToKilograms();
            }
        });
    }

    private void convertGramsToKilograms() {
        String gramsStr = weightEditText.getText().toString();
        if (gramsStr.isEmpty()) {
            weightTextView.setText("Enter weight in grams");
            return;
        }

        double grams = Double.parseDouble(gramsStr);
        double kilograms = grams / 1000;  // 1 gram = 0.001 kilograms

        // Format the result to two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedKilograms = decimalFormat.format(kilograms);

        weightTextView.setText(formattedKilograms + " kg");
    }
}
