package com.gbelot.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
                EditText txtNumber2 = (EditText) findViewById(R.id.txtNumber2);
                TextView txResults = (TextView) findViewById(R.id.txResults);

                int num1 = Integer.parseInt(txtNumber1.getText().toString());
                int num2 = Integer.parseInt(txtNumber2.getText().toString());
                int result = num1 + num2;
                txtNumber1.setText("");
                txtNumber2.setText("");

                txResults.setText(result + "");

            }
        });

    }


}