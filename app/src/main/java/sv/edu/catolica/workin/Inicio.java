package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.design_inicio);

        Handler manejador = new Handler();

        manejador.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent objPant = new Intent(Inicio.this,Login.class);
                startActivity(objPant);
            }
        }, 4000);
    }
}
