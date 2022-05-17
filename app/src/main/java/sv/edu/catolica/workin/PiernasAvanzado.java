package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PiernasAvanzado extends AppCompatActivity {
    Button btnTerminar;
    int contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rutina_piernas_avanzado);

        btnTerminar=findViewById(R.id.btnPiernaconcluirAvanzado);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }
    public void infopunetazos(View view)
    {
        Intent infopunetazos= new Intent(PiernasAvanzado.this,Punetazos.class);
        startActivity(infopunetazos);
    }
    public void infotijera(View view)
    {
        Intent infotijera= new Intent(PiernasAvanzado.this,SaltoTijera.class);
        startActivity(infotijera);
    }

    public void infoburpees(View view)
    {
        Intent infoburpee= new Intent(PiernasAvanzado.this,Burpees.class);
        startActivity(infoburpee);
    }

    public void infosentadilla(View view)
    {
        Intent infosentadilla= new Intent(PiernasAvanzado.this,Sentadilla.class);
        startActivity(infosentadilla);
    }

    public void infoelevacionlateral(View view)
    {
        Intent infoelevacion= new Intent(PiernasAvanzado.this,ElevacionLateral.class);
        startActivity(infoelevacion);
    }

    public void infofirehydrant(View view)
    {
        Intent infofire= new Intent(PiernasAvanzado.this,FireHydrant.class);
        startActivity(infofire);
    }

    public void infosentadillasalto(View view)
    {
        Intent infosentadillasalto= new Intent(PiernasAvanzado.this,SentadillaConSalto.class);
        startActivity(infosentadillasalto);
    }

    public void infoelevacionrodillas(View view)
    {
        Intent infoelevacionrodilla= new Intent(PiernasAvanzado.this,ElevacionRodilla.class);
        startActivity(infoelevacionrodilla);
    }

    public void infowallsit(View view)
    {
        Intent infowallsit= new Intent(PiernasAvanzado.this,WallSit.class);
        startActivity(infowallsit);
    }

    public void infodezplantecruzado(View view)
    {
        Intent infodesplante= new Intent(PiernasAvanzado.this,DezplanteCruzado.class);
        startActivity(infodesplante);
    }

    public void infopantorrillas(View view)
    {
        Intent infopantorillas= new Intent(PiernasAvanzado.this,ElevacionDePuntas.class);
        startActivity(infopantorillas);
    }

    public void finentrenamientoPierAvan(View view)
    {
        contador=u.getRutinaPiernas();
        contador+=1;
        u.setRutinaPiernas(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}