package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView resultField;
    private Integer value = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultField = findViewById(R.id.result);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);

        button1.setOnClickListener(v -> resultField.setText(resultField.getText() + "1"));
        button2.setOnClickListener(v -> resultField.setText(resultField.getText() + "2"));
        button3.setOnClickListener(v -> resultField.setText(resultField.getText() + "3"));
        button4.setOnClickListener(v -> resultField.setText(resultField.getText() + "4"));
        button5.setOnClickListener(v -> resultField.setText(resultField.getText() + "5"));
        button6.setOnClickListener(v -> resultField.setText(resultField.getText() + "6"));
        button7.setOnClickListener(v -> resultField.setText(resultField.getText() + "7"));
        button8.setOnClickListener(v -> resultField.setText(resultField.getText() + "8"));
        button9.setOnClickListener(v -> resultField.setText(resultField.getText() + "9"));
        button0.setOnClickListener(v -> resultField.setText(resultField.getText() + "0"));
    }


}
