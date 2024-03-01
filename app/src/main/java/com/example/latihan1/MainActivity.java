
package com.example.latihan1;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText input1EditText;
    private EditText input2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1EditText = findViewById(R.id.input1);
        input2EditText = findViewById(R.id.input2);
        resultTextView = findViewById(R.id.textViewResult);

        Button multiplyButton = findViewById(R.id.mul);
        Button divideButton = findViewById(R.id.div);
        Button subtractButton = findViewById(R.id.min);
        Button addButton = findViewById(R.id.plus);

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });
    }

    private void calculate(char operator) {
        double value1 = 0.0, value2 = 0.0;
        if(input1EditText.getText().toString().isEmpty()){
            // Tampilkan notifikasi untuk memasukkan angka pada input 1
            Toast.makeText(getApplicationContext(), "Masukkan angka pada input 1", Toast.LENGTH_SHORT).show();
        } else {
            value1 = Double.parseDouble(input1EditText.getText().toString());
        }
        if(input2EditText.getText().toString().isEmpty()){
            // Tampilkan notifikasi untuk memasukkan angka pada input 2
            Toast.makeText(getApplicationContext(), "Masukkan angka pada input 2", Toast.LENGTH_SHORT).show();
        } else {
            value2 = Double.parseDouble(input2EditText.getText().toString());
        }

        double result =0;

        switch (operator) {
            case '*':
                result = value1 * value2;
                break;
            case '/':
                result = value1 / value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '+':
                result = value1 + value2;
                break;
        }

        resultTextView.setText(String.valueOf(result));
    }
}