package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int num1;
    int num2;
    char operator;
    String strOP;
    String str;

    boolean isItFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void funcButtonClick(View view) {
        Button button = (Button) view;
        str = button.getText().toString();
        textView.append(str);
        str = textView.getText().toString();
    }

    public void operator(View view) {
        if (isItFirst == true) {
            System.out.println("num1");
            num1 = Integer.parseInt(str);
            isItFirst = false;
        }
        textView.setText("");

        Button button = (Button) view;
        operator = button.getText().toString().charAt(0);

    }
    public void equal(View view) {
        System.out.println("num2");
        num2 = Integer.parseInt(str);
        isItFirst = true;


        System.out.println(num2);
        System.out.println(num1);
        switch (operator) {
            case '-':
                textView.setText(Double.toString(num1 - num2));
                break;
            case '+':
                textView.setText(Double.toString(num1 + num2));
                break;
            case 'X':
                textView.setText(Double.toString(num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    textView.setText(Double.toString(num1 / num2));
                    break;
                }
                else{
                    textView.setText("ERROR");
                    break;
                }
        }
    }

    public void AC(View view) {
        textView.setText("");
        isItFirst = true;
    }
}