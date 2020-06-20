package com.gbelot.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumber1;
    private EditText txtNumber2;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkFieldsForEmptyValues();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private  void checkFieldsForEmptyValues(){
        Button b = (Button) findViewById(R.id.addBtn);
        EditText txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        EditText txtNumber2 = (EditText) findViewById(R.id.txtNumber2);

        String s1 = txtNumber1.getText().toString();
        String s2 = txtNumber2.getText().toString();

        if (s1.trim().isEmpty() || s2.trim().isEmpty()) {
            b.setEnabled(false);
        } else {
            b.setEnabled(true);
        }
    }

    private void calcularSuma()
    {
        EditText txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        EditText txtNumber2 = (EditText) findViewById(R.id.txtNumber2);
        TextView txResults = (TextView) findViewById(R.id.txResults);

        int num1 = Integer.parseInt(txtNumber1.getText().toString());
        int num2 = Integer.parseInt(txtNumber2.getText().toString());
        int result = num1 + num2;

        txtNumber1.setText("");
        txtNumber2.setText("");

        txResults.setText(String.valueOf(result));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtNumber1 = (EditText) findViewById(R.id.txtNumber1);
        EditText txtNumber2 = (EditText) findViewById(R.id.txtNumber2);
        txtNumber1.addTextChangedListener(textWatcher);
        txtNumber2.addTextChangedListener(textWatcher);

        checkFieldsForEmptyValues();
        Button addBtn = (Button) findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularSuma();
            }
        });

    }


}