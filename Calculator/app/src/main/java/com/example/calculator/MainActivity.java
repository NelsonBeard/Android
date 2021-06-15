package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView resultField;
    private Double value1 = null;
    private Double value2 = null;
    private Double result = null;
    private String lastOperation = "";
    Boolean ableToPutPoint2 = true;
    Boolean ableToPutPoint1 = true;

    final String DIVISION = "/";
    final String MULTIPLICATION = "*";
    final String PLUS = "+";
    final String MINUS = "-";
    final String EQUALS = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSettings = findViewById(R.id.button_settings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(runSettings);
            }
        });

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
        Button button_point = findViewById(R.id.button_point);

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
        button_point.setOnClickListener(v -> {
            ableToPutPoint1 = resultField.getText().toString().endsWith("1") || resultField.getText().toString().endsWith("2") ||
                    resultField.getText().toString().endsWith("3") || resultField.getText().toString().endsWith("4") ||
                    resultField.getText().toString().endsWith("5") || resultField.getText().toString().endsWith("6") ||
                    resultField.getText().toString().endsWith("7") || resultField.getText().toString().endsWith("8") ||
                    resultField.getText().toString().endsWith("9") || resultField.getText().toString().endsWith("0");

            if (ableToPutPoint1 == true && ableToPutPoint2 == true) {
                ableToPutPoint2 = false;
                onNumberClick(v);
            }
        });
    }

    public void onOperationClick(View view) {
        Button button = (Button) view;
        lastOperation = button.getText().toString();
        resultField.append(button.getText());
        ableToPutPoint2 = true;
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        if (lastOperation == EQUALS) {
            resultField.setText("");
            lastOperation = "";
            ableToPutPoint2 = true;
        }
        resultField.append(button.getText());
    }

    public void onOperationClickClear(View view) {
        Button button = (Button) view;
        resultField.setText("");
        ableToPutPoint2 = true;

    }

    public void onOperationClickDelete(View view) {
        Button button = (Button) view;
        String str = resultField.getText().toString();
        if (str.length() != 0) {
            str = str.substring(0, str.length() - 1);
            resultField.setText(str);
        }
    }

    public void onOperationClickResult(View view) {
        String value = resultField.getText().toString();
        String values[] = value.split(Pattern.quote(lastOperation));
        if (values.length == 2) {
            try {
                value1 = Double.valueOf(values[0].replace(',', '.'));
                value2 = Double.valueOf(values[1].replace(',', '.'));
                performOperation(value1, value2, lastOperation);
            } catch (NumberFormatException ex) {
                resultField.setText("");
            }
        }
        lastOperation = EQUALS;
        ableToPutPoint1 = false;
    }

    private void performOperation(Double value1, Double value2, String operation) {

        switch (operation) {
            case DIVISION:
                if (value2 == 0) {
                    result = 0.0;
                } else {
                    result = value1 / value2;
                }
                break;
            case MULTIPLICATION:
                result = value1 * value2;
                break;
            case PLUS:
                result = value1 + value2;
                break;
            case MINUS:
                result = value1 - value2;
                break;
        }
        resultField.setText(result.toString().replace('.', ','));

    }
}