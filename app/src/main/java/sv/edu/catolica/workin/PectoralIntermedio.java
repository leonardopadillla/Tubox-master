package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PectoralIntermedio extends AppCompatActivity {
    Button btnTerminar;
    int contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rutina_pectoral_intermedio);

        btnTerminar=findViewById(R.id.btnPecconcluirInter);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }

    public void infotijera(View view)
    {
        Intent infotijera= new Intent(PectoralIntermedio.this,SaltoTijera.class);
        startActivity(infotijera);
    }

    public void infoflexionpared(View view)
    {
        Intent infoflexionpared= new Intent(PectoralIntermedio.this,FlexionContraPared.class);
        startActivity(infoflexionpared);
    }

    public void infoflexiones(View view)
    {
        Intent infoflexiones= new Intent(PectoralIntermedio.this,Flexiones.class);
        startActivity(infoflexiones);
    }

    public void infoflexionestrella(View view)
    {
        Intent infoflexionesestre= new Intent(PectoralIntermedio.this,FlexionEstrella.class);
        startActivity(infoflexionesestre);
    }
    public void infopunetazos(View view)
    {
        Intent infopunos= new Intent(PectoralIntermedio.this,Punetazos.class);
        startActivity(infopunos);
    }
    public void infoflexionespiernaselevadas(View view)
    {
        Intent infoflexionpiernas= new Intent(PectoralIntermedio.this,FlexionPiernasElevadas.class);
        startActivity(infoflexionpiernas);
    }

    public void infoestiramientopecho(View view)
    {
        Intent infoestirapecho= new Intent(PectoralIntermedio.this,EstiramientoPecho.class);
        startActivity(infoestirapecho);
    }

    public void infoflexionesconrotacion(View view)
    {
        Intent infoflexionrotacion= new Intent(PectoralIntermedio.this,FlexionesConRotacion.class);
        startActivity(infoflexionrotacion);
    }

    public void infoflexionesdivebomber(View view)
    {
        Intent infoflexiondivebomber= new Intent(PectoralIntermedio.this,FlexionesDivebomber.class);
        startActivity(infoflexiondivebomber);
    }
    public void finentrenamientoPecInter(View view)
    {
        contador=u.getRutinaPecho();
        contador+=1;
        u.setRutinaPecho(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}