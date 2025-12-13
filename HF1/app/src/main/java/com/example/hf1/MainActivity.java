package com.example.hf1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1;
    private EditText etNumber2;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvResult);
    }

    public void onOperationClick(View view) {
        try {
            String num1Str = etNumber1.getText().toString();
            String num2Str = etNumber2.getText().toString();

            if (num1Str.isEmpty() || num2Str.isEmpty()) {
                Toast.makeText(this, "Kérlek mindkét mezőt töltsd ki!", Toast.LENGTH_SHORT).show();
                return;
            }

            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0.0;
            String operation = "";
            Button b = (Button) view;
            operation = b.getText().toString();

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        tvResult.setText("Hiba: Nullával való osztás!");
                         return;
                    }
                    result = num1 / num2;
                    break;
                default:
                       tvResult.setText("Ismeretlen művelet!");
                    return;
            }
            String resultText = String.format("Eredmény: %.2f", result); // Két tizedesjegyre kerekítve
            tvResult.setText(resultText);

        } catch (NumberFormatException e) {
            tvResult.setText("Hiba: Érvénytelen számformátum!");
            Toast.makeText(this, "Kérlek, valós számot adj meg!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (Exception e) {
            tvResult.setText("Váratlan hiba történt.");
            e.printStackTrace();
        }
    }
}