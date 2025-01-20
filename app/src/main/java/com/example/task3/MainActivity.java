package com.example.task3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private Button btnMc, btnMs, btnMplus, btnMminus, btnCe, btnC, btnAdd, btnSubtract, btnMultiply, btnDivide, btnPercent, btnInverse, btnSqrt, btnSign, btnEquals, btnZero, btnDot;

    private CalculatorLogic calculator;
    private double firstOperand;
    private double secondOperand;
    private String operation;
    private boolean isOperatorJustPressed = false;
    private boolean isDecimalPointAdded = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        btnZero = findViewById(R.id.btn_zero);
        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnMultiply = findViewById(R.id.btn_dot);
        btnDivide = findViewById(R.id.btn_divide);
        btnPercent = findViewById(R.id.btn_percent);
        btnInverse = findViewById(R.id.btn_inverse);
        btnSqrt = findViewById(R.id.btn_sqrt);
        btnSign = findViewById(R.id.btn_sign);
        btnEquals = findViewById(R.id.btn_equals);
        btnMc = findViewById(R.id.btn_mc);
        btnMs = findViewById(R.id.btn_ms);
        btnMplus = findViewById(R.id.btn_mplus);
        btnMminus = findViewById(R.id.btn_mminus);

        calculator = new CalculatorLogic();

        btnZero.setOnClickListener(v -> appendDigit("0"));
        btnAdd.setOnClickListener(v -> setOperation("+"));
        btnSubtract.setOnClickListener(v -> setOperation("-"));
        btnMultiply.setOnClickListener(v -> setOperation("*"));
        btnDivide.setOnClickListener(v -> setOperation("/"));
        btnPercent.setOnClickListener(v -> setOperation("%"));
        btnInverse.setOnClickListener(v -> setOperation("1/x"));
        btnSqrt.setOnClickListener(v -> setOperation("sqrt"));
        btnSign.setOnClickListener(v -> setOperation("sign"));
        btnEquals.setOnClickListener(v -> calculateResult());
        btnMc.setOnClickListener(v -> calculator.memoryClear());
        btnMs.setOnClickListener(v -> calculator.memoryStore(Double.parseDouble(display.getText().toString())));
        btnMplus.setOnClickListener(v -> calculator.memoryAdd(Double.parseDouble(display.getText().toString())));
        btnMminus.setOnClickListener(v -> calculator.memorySubtract(Double.parseDouble(display.getText().toString())));
    }

    private void appendDigit(String digit) {
        if (display.getText().toString().equals("0") || isOperatorJustPressed) {
            display.setText(digit);
        } else {
            display.setText(display.getText().toString() + digit);
        }
        isOperatorJustPressed = false;
        if (digit.equals(".")) {
            if (!isDecimalPointAdded && !display.getText().toString().contains(".")) {
                display.setText(display.getText().toString() + ".");
                isDecimalPointAdded = true;
            }
        } else {
            isDecimalPointAdded = false;
        }
    }
    private void setOperation(String op) {
        if (!display.getText().toString().equals("0")) {
            firstOperand = Double.parseDouble(display.getText().toString());
        }
        operation = op;
        isOperatorJustPressed = true;
    }
    private void calculateResult() {
        secondOperand = Double.parseDouble(display.getText().toString());
        double result = calculator.calculate(firstOperand, secondOperand, operation);
        if (!Double.isNaN(result)) {
            display.setText(String.valueOf(result));
        } else {
            display.setText("Error");
        }
        // Reset variables for next operation
        firstOperand = result;
        secondOperand = 0;
        operation = "";
        isOperatorJustPressed = false;
    }
}