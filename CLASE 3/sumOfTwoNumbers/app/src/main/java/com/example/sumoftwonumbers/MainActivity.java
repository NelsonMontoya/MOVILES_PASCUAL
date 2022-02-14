package com.example.sumoftwonumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numberOne, numberTwo;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOne = (EditText) findViewById(R.id.numeroUno);
        numberTwo = (EditText) findViewById(R.id.numeroDos);
        result = (TextView) findViewById(R.id.resultadoSuma);
    }


    public void suma(View view){
        //String numeroUno = numberOne.getText().toString();
        //String numeroDos = numberTwo.getText().toString();
        //int valorUno = Integer.parseInt(numeroUno);
        //int valorDos = Integer.parseInt(numeroDos);
        int valorUno = Integer.parseInt(numberOne.getText().toString());
        int valorDos = Integer.parseInt(numberTwo.getText().toString());
        int suma = valorUno+valorDos;
        //String resultado = String.valueOf(suma);
        //result.setText(resultado);
        result.setText(String.valueOf(suma));
    }
}