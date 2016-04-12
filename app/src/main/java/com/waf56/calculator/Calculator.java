package com.waf56.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    private Button clear, plus, minus, egal, launchActivity;

    private TextView resultView;

    private GridLayout buttonPanel;

    private int currentValue;

    enum Operation {
        MINUS, PLUS
    }

    Operation currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Log.d("TestApp", "test message");

        clear = (Button) findViewById(R.id.clear);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        egal = (Button) findViewById(R.id.egal);

        resultView = (TextView) findViewById(R.id.result_view);

        buttonPanel = (GridLayout) findViewById(R.id.buttonPanel);

        launchActivity = (Button) findViewById(R.id.launch_activity);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText(null);
            }
        });


        for (int i = 0; i < buttonPanel.getChildCount(); i++) {
            final Button button = (Button) buttonPanel.getChildAt(i);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String currentValue = resultView.getText().toString();
                    currentValue = currentValue + button.getText().toString();
                    resultView.setText(currentValue);
                }
            });
        }

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue = Integer.parseInt(resultView.getText().toString());
                resultView.setText(null);
                currentOperation = Operation.PLUS;
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentValue = Integer.parseInt(resultView.getText().toString());
                resultView.setText(null);
                currentOperation = Operation.MINUS;
            }
        });

        egal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = Integer.parseInt(resultView.getText().toString());
                int sum = 0;
                switch (currentOperation){
                    case MINUS:
                        sum = currentValue - temp;
                        break;
                    case PLUS:
                        sum = temp + currentValue;
                        break;
                }

                resultView.setText(sum + "");
            }
        });


        launchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calculator.this, TestActivity.class);
                startActivity(intent);
            }
        });

    }
}
