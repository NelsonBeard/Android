package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView resultField;
    private Double value1 = null;
    private Double value2 = null;
    private Double result = null;
    private String lastOperation = "=";

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

        button1.setOnClickListener(v -> onNumberClick(v));
        button2.setOnClickListener(v -> onNumberClick(v));
        button3.setOnClickListener(v -> onNumberClick(v));
        button4.setOnClickListener(v -> onNumberClick(v));
        button5.setOnClickListener(v -> onNumberClick(v));
        button6.setOnClickListener(v -> onNumberClick(v));
        button7.setOnClickListener(v -> onNumberClick(v));
        button8.setOnClickListener(v -> onNumberClick(v));
        button9.setOnClickListener(v -> onNumberClick(v));
        button0.setOnClickListener(v -> onNumberClick(v));
    }
    public void onOperationClick(View view) {
        Button button = (Button) view;
        lastOperation = button.getText().toString();
        resultField.append(button.getText());
    }

    public void onOperationClickResult(View view){
        String value = resultField.getText().toString();
        String values[] = value.split(Pattern.quote(lastOperation));
        value1 = Double.valueOf(values[0]);
        value2 = Double.valueOf(values[1]);

            try{
                performOperation(value1, value2, lastOperation);
            }catch (NumberFormatException ex){
                resultField.setText("");
            }
    }

    public void onNumberClick(View view){
        Button button = (Button)view;
        resultField.append(button.getText());

    }

    private void performOperation(Double value1, Double value2, String operation) {

        switch (operation) {
            case "/":
                if (value2 == 0) {
                    result = 0.0;
                } else {
                    result = value1 / value2;
                }
                break;
            case "*":
                result = value1 * value2;
                break;
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
        }
        resultField.setText(result.toString().replace('.', ','));
    }
}