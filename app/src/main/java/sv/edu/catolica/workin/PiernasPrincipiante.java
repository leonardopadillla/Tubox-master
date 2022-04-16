package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PiernasPrincipiante extends AppCompatActivity {
    Button btnTerminar;
    int contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rutina_piernas_principiante);

        btnTerminar=findViewById(R.id.btnPiernasconcluirPrin);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }

    public void infotijera(View view)
    {
        Intent infotijera= new Intent(PiernasPrincipiante.this,SaltoTijera.class);
        startActivity(infotijera);
    }

    public void infosentadilla(View view)
    {
        Intent infosentadilla= new Intent(PiernasPrincipiante.this,Sentadilla.class);
        startActivity(infosentadilla);
    }

    public void infosentadillasalto(View view)
    {
        Intent infosentadillasalto= new Intent(PiernasPrincipiante.this,SentadillaConSalto.class);
        startActivity(infosentadillasalto);
    }

    public void infoelevacionlateral(View view)
    {
        Intent infoelevacion= new Intent(PiernasPrincipiante.this,ElevacionLateral.class);
        startActivity(infoelevacion);
    }

    public void infopatadaburro(View view)
    {
        Intent infopatada= new Intent(PiernasPrincipiante.this,PatadaDeBurro.class);
        startActivity(infopatada);
    }

    public void infofirehydrant(View view)
    {
        Intent infofire= new Intent(PiernasPrincipiante.this,FireHydrant.class);
        startActivity(infofire);
    }

    public void finentrenamientoPierPrin(View view)
    {
        contador=u.getRutinaPiernas();
        contador+=1;
        u.setRutinaPiernas(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}