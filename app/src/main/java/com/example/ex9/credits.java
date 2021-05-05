package com.example.ex9;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class credits extends AppCompatActivity {
    double result;
    Intent gi;
    TextView textView;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        textView = findViewById(R.id.textView);
        gi = getIntent();
        result = gi.getDoubleExtra("result", 1);
        textView.setText("the last result is " + result + "\n Thank to Albert Levi the best teacher :)");
    }

    public void backTo(View view) {
        Intent si = new Intent(this,MainActivity.class);
        si.putExtra("result",result);
        startActivity(si);
    }
}