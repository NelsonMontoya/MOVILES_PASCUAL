package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_one,btn_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_one= (Button) findViewById(R.id.button);
        btn_two= (Button) findViewById(R.id.button2);
        btn_one.setOnClickListener(this);

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hola desde botón uno",Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public void onClick(View view) {

        if (view.getId() == btn_one.getId()){
            Toast.makeText(getApplicationContext(),"Hola desde botón uno",Toast.LENGTH_LONG).show();
        }

        if (view.getId() == btn_two.getId()){
            Toast.makeText(getApplicationContext(),"Hola desde botón dos",Toast.LENGTH_LONG).show();
        }

    }
}