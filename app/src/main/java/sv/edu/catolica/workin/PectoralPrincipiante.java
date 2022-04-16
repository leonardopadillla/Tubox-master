package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PectoralPrincipiante extends AppCompatActivity {
    Button btnTerminar;
    int contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rutina_pectoral_principiante);

        btnTerminar=findViewById(R.id.btnPecconcluirPrin);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }

    public void infotijera(View view)
    {
        Intent infotijera= new Intent(PectoralPrincipiante.this,SaltoTijera.class);
        startActivity(infotijera);
    }

    public void infoflexionpared(View view)
    {
        Intent infoflexionpared= new Intent(PectoralPrincipiante.this,FlexionContraPared.class);
        startActivity(infoflexionpared);
    }

    public void infoflexiones(View view)
    {
        Intent infoflexiones= new Intent(PectoralPrincipiante.this,Flexiones.class);
        startActivity(infoflexiones);
    }

    public void infoflexionestrella(View view)
    {
        Intent infoflexionesestre= new Intent(PectoralPrincipiante.this,FlexionEstrella.class);
        startActivity(infoflexionesestre);
    }

    public void infoflexionespiernaselevadas(View view)
    {
        Intent infoflexionpiernas= new Intent(PectoralPrincipiante.this,FlexionPiernasElevadas.class);
        startActivity(infoflexionpiernas);
    }

    public void infoestiramientopecho(View view)
    {
        Intent infoestirapecho= new Intent(PectoralPrincipiante.this,EstiramientoPecho.class);
        startActivity(infoestirapecho);
    }

    public void finentrenamientoPecPrin(View view)
    {
        contador=u.getRutinaPecho();
        contador+=1;
        u.setRutinaPecho(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}