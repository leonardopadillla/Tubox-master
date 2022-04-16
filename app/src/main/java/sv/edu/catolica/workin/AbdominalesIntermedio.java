package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AbdominalesIntermedio extends AppCompatActivity {
    Button btnTerminar;
    int contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desingabdominales_intermedio);

        btnTerminar = findViewById(R.id.btnAbconcluirInter);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }

    public void infotijera(View view)
    {
        Intent infotijera= new Intent(AbdominalesIntermedio.this,SaltoTijera.class);
        startActivity(infotijera);
    }

    public void infoabcruzados(View view)
    {
        Intent infoabcruzados= new Intent(AbdominalesIntermedio.this,AbdominalCruzado.class);
        startActivity(infoabcruzados);
    }

    public void infoabelevados(View view)
    {
        Intent infoabelevados= new Intent(AbdominalesIntermedio.this,AbdominalesElevados.class);
        startActivity(infoabelevados);
    }

    public void infolevantamiento(View view)
    {
        Intent infolevantamiento= new Intent(AbdominalesIntermedio.this,LevantamientoDePiernas.class);
        startActivity(infolevantamiento);
    }

    public void infoelevacionlateral(View view)
    {
        Intent infoelevacionlat= new Intent(AbdominalesIntermedio.this,ElevacionLateral.class);
        startActivity(infoelevacionlat);
    }

    public void infoabenv(View view)
    {
        Intent infoabenv= new Intent(AbdominalesIntermedio.this,AbdominalesV.class);
        startActivity(infoabenv);
    }

    public void infoelevacioncadera(View view)
    {
        Intent infoelevacioncadera= new Intent(AbdominalesIntermedio.this,ElevacionCadera.class);
        startActivity(infoelevacioncadera);
    }

    public void finentrenamientointermedio(View view)
    {
        contador=u.getRutinaAbdomen();
        contador+=1;
        u.setRutinaAbdomen(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}