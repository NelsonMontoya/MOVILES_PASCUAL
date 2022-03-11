package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String TAG = "ActividadUno";
    Button crearAlarma, llamar;
    String phoneNumber = "6046041616";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"--OnCreate--");
    }

    @Override
    protected void onStart() {
        super.onStart();
        crearAlarma = findViewById(R.id.crearAlarma);
        crearAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearAlarma();
            }
        });

        llamar = findViewById(R.id.hacerLlamada);
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hacerUnaLlamada(phoneNumber);
            }
        });

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
        String email = "clase@gmail.com";
        String pass = "12345@";
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("email",email);
        intent.putExtra("password",pass);
        startActivity(intent);
        Log.i("intent",""+ email + " " +pass);

    }

    public void gotoGoogle(View view){
        /*ACTION_VIEW
        *Usa esta acción en una intent con startActivity() cuando tengas información que la
        * actividad pueda mostrar al usuario, como una foto para ver en una app de galería
        * o una dirección para ver en una app de mapas.
        * */
        Intent irAGoogle = new Intent(Intent.ACTION_VIEW);
        irAGoogle.setData(Uri.parse("http://www.google.com"));
        startActivity(irAGoogle);
    }

    public void crearAlarma(){
        Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE,"Gimnasio")
                .putExtra(AlarmClock.EXTRA_HOUR, 5)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30);

        if(alarma.resolveActivity(getPackageManager())!= null){
            startActivity(alarma);
        }

    }

    public void hacerUnaLlamada(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }





}

