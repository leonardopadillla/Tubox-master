package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PectoralesAvanzado extends AppCompatActivity {
    Button btnTerminar;
    int contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rutinas_pectorales_avanzado);

        btnTerminar=findViewById(R.id.btnPecconcluirInter);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }

    public void infotijera(View view)
    {
        Intent infotijera= new Intent(PectoralesAvanzado.this,SaltoTijera.class);
        startActivity(infotijera);
    }

    public void infomovimientocirculo(View view)
    {
        Intent infomovcir= new Intent(PectoralesAvanzado.this,MovimientoCircular.class);
        startActivity(infomovcir);
    }

    public void infopunetazos(View view)
    {
        Intent infopunos= new Intent(PectoralesAvanzado.this,Punetazos.class);
        startActivity(infopunos);
    }

    public void infoburpees(View view)
    {
        Intent infoburpee= new Intent(PectoralesAvanzado.this,Burpees.class);
        startActivity(infoburpee);
    }

    public void infoflexiones(View view)
    {
        Intent infoflexiones= new Intent(PectoralesAvanzado.this,Flexiones.class);
        startActivity(infoflexiones);
    }

    public void infoflexionespider(View view)
    {
        Intent infoflexionspider= new Intent(PectoralesAvanzado.this,FlexionesSpider.class);
        startActivity(infoflexionspider);
    }

    public void infoflexionesconrotacion(View view)
    {
        Intent infoflexionrotacion= new Intent(PectoralesAvanzado.this,FlexionesConRotacion.class);
        startActivity(infoflexionrotacion);
    }

    public void infoflexionesdivebomber(View view)
    {
        Intent infoflexiondivebomber= new Intent(PectoralesAvanzado.this,FlexionesDivebomber.class);
        startActivity(infoflexiondivebomber);
    }

    public void infoestiramientohombro(View view)
    {
        Intent infoestiramientohombro= new Intent(PectoralesAvanzado.this,EstiramientoHombro.class);
        startActivity(infoestiramientohombro);
    }

    public void infocobra(View view)
    {
        Intent infocobra= new Intent(PectoralesAvanzado.this,Cobra.class);
        startActivity(infocobra);
    }
    public void finentrenamientoPecAvan(View view)
    {
        contador=u.getRutinaPecho();
        contador+=1;
        u.setRutinaPecho(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}