package com.example.nov4lab;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculate {


    //    String[] userInput = new String[10];
    ArrayList<String> inputList = new ArrayList<String>();
    int index = 0;
    int oneResult;


    //showToast in a non-activity class
//    private Context getApplicationContext;
//
//    public static void showToast(Context context, String message) {
//        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
//    }

    //make sure the right value (number or operator) is entered
//    boolean isNum(String input) {
//        int inputNum;
//        try {
//            inputNum = Integer.parseInt(input);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;    }
//
//    }


    public void push(String input) {
        inputList.add(input);
        index++;
//        if (index % 2 != 0) {
//            if (inputList.get(index) == "+" || inputList.get(index) == "-" || inputList.get(index) == "*" || inputList.get(index) == "/") {
//                inputList.add(input);
//                index++;
//            } else {
//                showToast(getApplicationContext, "Only single digit number is allowed");
//            }
//        } else {
//            if (inputList.get(index).isNum) {
//                inputList.add(input);
//            } else {
//                showToast(getApplicationContext, "Please enter a number");
//            }
//        }
    }
//



    int calculate() {
        int index = 0;
        oneResult = Integer.parseInt(inputList.get(index));

        for (index = 1; index < inputList.size() - 1; index++) {
            if ((inputList.get(index).charAt(0) == '+' || inputList.get(index).charAt(0) == '-' || inputList.get(index).charAt(0) == '*' || inputList.get(index).charAt(0) == '/')) {
                char op = inputList.get(index).charAt(0);
                int num2 = Integer.parseInt(inputList.get(index + 1));
                oneResult = calculateResult(oneResult, num2, op);
                System.out.println(inputList);
            }
        }
        return oneResult;
    }




    int calculateResult(int n1,int n2, char op) {
        int result = 0;
        System.out.println("n1:" + n1 + "n2:" + n2 + "op:" + op);

    switch (op) {
        case '+':
            result = n1 + n2;
            break;
        case '-':
            result = n1 - n2;
            break;
        case '*':
            result = n1 * n2;
            break;
        case '/':
            result = n1 / n2;
            break;

    }
        System.out.println("result is " + result);

    return result;

}

void clear() {
        //empty the string array and reset the index number
//       userInput = new String[userInput.length];
    inputList.clear();
//    System.out.println(Arrays.toString(userInput));
    index = 0;

}


}
