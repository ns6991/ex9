package com.example.ex9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    String op="";
    int many_op =0;
    int retzef_op =0;
    double result = 0;
    double num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        plus = findViewById(R.id.plus1);
        minus = findViewById(R.id.minus1);
        multiply = findViewById(R.id.multiply1);
        divide = findViewById(R.id.divide1);
    }

    public void clear(){
        editText.setText(null);
        retzef_op =0;
        many_op =0;
        num1 = 0;
        result = 0;
    }
    public void update(String op1){
        num1 = Double.parseDouble(editText.getText().toString());
        editText.setText(null);
        many_op++;
        op = op1;
    }
    public void common(){
        retzef_op =0;
        if(many_op>0){
            num2 = Double.parseDouble(editText.getText() + "");
            if(op=="+"){
                result = num1+num2;
                editText.setText(Double.toString(result));

            }
            else if(op=="-"){
                result = num1-num2;
                editText.setText(Double.toString(result));
            }
            else if(op=="*"){
                result = num1*num2;
                editText.setText(Double.toString(result));
            }
            else if(op=="/"){
                if(num2==0){
                    Toast.makeText(getApplicationContext(), "Can't divide by 0! ",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = num1/num2;
                    editText.setText(Double.toString(result));
                }

            }
        }
    }
    public void pluss(View view) {
        try {
            common();
            update("+");
        }
        catch(Exception e) {
            Toast.makeText(getApplicationContext(), "Syntax Error! "+e,Toast.LENGTH_SHORT).show();
            clear();
        }
    }

    public void minuss(View view) {
        try {
            common();
            update("-");
        }
        catch(Exception e) {
            Toast.makeText(getApplicationContext(), "Syntax Error! "+e,Toast.LENGTH_SHORT).show();
            clear();
        }
    }

    public void multiplyy(View view) {
        try {
            common();
            update("*");
        }
        catch(Exception e) {
            Toast.makeText(getApplicationContext(), "Syntax Error! "+e,Toast.LENGTH_SHORT).show();
            clear();
        }
    }

    public void dividee(View view) {
        try {
            common();
            update("/");
        }
        catch(Exception e) {
            Toast.makeText(getApplicationContext(), "Syntax Error! "+e,Toast.LENGTH_SHORT).show();
            clear();
        }
    }



    public void ac(View view) {
        clear();
    }

    public void calculate(View view) {
        try {
            common();
            retzef_op++;
            many_op=0;
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Syntax Error! "+e,Toast.LENGTH_SHORT).show();
            clear();
        }

    }

    public void credits(View view) {
        Intent si = new Intent(this,credits.class);
        si.putExtra("result",result);
        startActivity(si);
    }
}