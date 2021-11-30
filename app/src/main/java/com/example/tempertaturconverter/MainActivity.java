package com.example.tempertaturconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button ansBtn,againBtn;
    TextView showAns;
    EditText getVal;
    RadioButton c2f,f2c;
    Double x;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansBtn= (Button) findViewById(R.id.ansBtn);
        showAns= (TextView) findViewById(R.id.showAns);
        getVal= (EditText) findViewById(R.id.getVal);
        c2f= (RadioButton) findViewById(R.id.c2f);
        f2c=(RadioButton) findViewById(R.id.f2c);
        againBtn=(Button) findViewById(R.id.againBtn);
        ansBtn.setOnClickListener(v -> {
            if (getVal.getText().toString().isEmpty()) {
                showAns.setText("please give Temperature");
            } else {
                x=Double.parseDouble(String.valueOf(getVal.getText()));
               if (c2f.isChecked()){
                    x= (x*9)/5+32;
                    showAns.setText(x +"Degree F");
               }
               else if (f2c.isChecked()){
                   x = ((x - 32) * 5) / 9;
                   showAns.setText(x +"Degree C");
               }
               else{
                   showAns.setText("please select an option!");
               }
            }
        });
       againBtn.setOnClickListener(this::onClick);
    }


    private void onClick(View v) {
        showAns.setText("0.0");
        getVal.setText("");
        c2f.setChecked(false);
        f2c.setChecked(false);

    }
}