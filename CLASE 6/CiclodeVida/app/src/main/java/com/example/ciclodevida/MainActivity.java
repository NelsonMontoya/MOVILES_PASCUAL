package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String TAG = "ActividadUno";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"--OnCreate--");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"--onStart--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"--onRestart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"--onResume--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"--onPause--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"--onStop--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"--onDestroy--");
    }

    public void gotoActivity2(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }

}

