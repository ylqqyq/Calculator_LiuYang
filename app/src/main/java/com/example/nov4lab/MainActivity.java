package com.example.nov4lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button clear_btn;
    Button eql_btn;
    Button plus_btn;
    Button minus_btn;
    Button multiply_btn;
    Button div_btn;
    TextView myDisplay;
    String displayStr = "";

    Calculate calc = new Calculate();

    Button historyView_btn;
    TextView history_display;
    String historyStr = "";
    ArrayList<String> historyArrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.num0);
        btn0.setOnClickListener(this);
        btn1 = findViewById(R.id.num1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.num2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.num3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.num4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.num5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.num6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.num7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.num8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.num9);
        btn9.setOnClickListener(this);
        plus_btn = findViewById(R.id.plus);
        plus_btn.setOnClickListener(this);
        minus_btn = findViewById(R.id.minus);
        minus_btn.setOnClickListener(this);
        multiply_btn = findViewById(R.id.multiply);
        multiply_btn.setOnClickListener(this);
        div_btn = findViewById(R.id.divide);
        div_btn.setOnClickListener(this);
        eql_btn = findViewById(R.id.equal);
        eql_btn.setOnClickListener(this);
        clear_btn = findViewById(R.id.clear);
        clear_btn.setOnClickListener(this);
        historyView_btn = findViewById(R.id.history_switch);
        historyView_btn.setOnClickListener(this);
        myDisplay = findViewById(R.id.result_display);
        history_display = findViewById(R.id.history_record);


    }

    @Override
    public void onClick(View v) {

        String data = ((Button) v).getText().toString();
        if (v == clear_btn) {
            calc.clear();
            //empty the array and reset the display here
            displayStr = "";
            myDisplay.setText(displayStr);
        } else if (v == eql_btn) {
            //equal is not pushed to the array so need to be added here
            if (history_display.getVisibility() == View.VISIBLE) {
                displayStr = displayStr + "=" + calc.calculate();
                myDisplay.setText(displayStr);
                historyArrayList.add(displayStr);
                System.out.println("history here" + historyArrayList);
                printHistory();

            } else {
                displayStr = displayStr + "=" + calc.calculate();
                myDisplay.setText(displayStr);
            }
        } else if (v == historyView_btn) {
            if (history_display.getVisibility() == View.INVISIBLE) {
                history_display.setVisibility(View.VISIBLE);
                historyView_btn.setText(R.string.standard_mode);
            } else {
                history_display.setVisibility(View.INVISIBLE);
                historyView_btn.setText(R.string.advance_mode);
            }
        } else {
            calc.push(data);
            displayStr += data;
            myDisplay.setText(displayStr);
        }
    }

    void printHistory() {
        history_display.setText(null);

        for (int index = 0; index < historyArrayList.size(); index++) {
//            if (index == 0) {

                history_display.append(historyArrayList.get(index));
                history_display.append("\n");
                System.out.println("list is" + historyArrayList);
//            } else {
//                historyArrayList.remove(historyArrayList.size()-2);
//                System.out.println("list is" + historyArrayList);
//                history_display.append(historyArrayList.get(index));
//                history_display.append("\n");
//
//            }
        }

    }}
