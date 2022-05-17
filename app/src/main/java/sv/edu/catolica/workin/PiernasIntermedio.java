package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PiernasIntermedio extends AppCompatActivity {
    Button btnTerminar;
    int contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rutina_piernas_intermedio);

        btnTerminar=findViewById(R.id.btnPierconcluirInter);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }

    public void infotijera(View view)
    {
        Intent infotijera= new Intent(PiernasIntermedio.this,SaltoTijera.class);
        startActivity(infotijera);
    }

    public void infosentadilla(View view)
    {
        Intent infosentadilla= new Intent(PiernasIntermedio.this,Sentadilla.class);
        startActivity(infosentadilla);
    }

    public void infofirehydrant(View view)
    {
        Intent infofire= new Intent(PiernasIntermedio.this,FireHydrant.class);
        startActivity(infofire);
    }

    public void infoelevacionlateral(View view)
    {
        Intent infoelevacion= new Intent(PiernasIntermedio.this,ElevacionLateral.class);
        startActivity(infoelevacion);
    }

    public void infoelevacionrodillas(View view)
    {
        Intent infoelevacionrodilla= new Intent(PiernasIntermedio.this,ElevacionRodilla.class);
        startActivity(infoelevacionrodilla);
    }

    public void infosentadillasalto(View view)
    {
        Intent infosentadillasalto= new Intent(PiernasIntermedio.this,SentadillaConSalto.class);
        startActivity(infosentadillasalto);
    }

    public void infopunetazos(View view)
    {
        Intent infopunetazos= new Intent(PiernasIntermedio.this,Punetazos.class);
        startActivity(infopunetazos);
    }

    public void infowallsit(View view)
    {
        Intent infowallsit= new Intent(PiernasIntermedio.this,WallSit.class);
        startActivity(infowallsit);
    }

    public void finentrenamientoPierInter(View view)
    {
        contador=u.getRutinaPiernas();
        contador+=1;
        u.setRutinaPiernas(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}