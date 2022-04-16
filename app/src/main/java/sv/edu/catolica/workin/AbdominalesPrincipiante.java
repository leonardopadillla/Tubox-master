package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AbdominalesPrincipiante extends AppCompatActivity {//implements View.OnClickListener{
    Button btnabprin;
    int c, contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desing_abdominales_principiante);

        btnabprin = findViewById(R.id.btnAbconcluirPrincipiante);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }

    public void infotijera(View view)
    {
        Intent infotijera= new Intent(AbdominalesPrincipiante.this,SaltoTijera.class);
        startActivity(infotijera);
    }

    public void infocrunch(View view)
    {
        Intent infocrunch= new Intent(AbdominalesPrincipiante.this,Crunch.class);
        startActivity(infocrunch);
    }

    public void infomountain(View view)
    {
        Intent infomountain= new Intent(AbdominalesPrincipiante.this,MountainClimber.class);
        startActivity(infomountain);
    }

    public void infoabelevados(View view)
    {
        Intent infoabelevados= new Intent(AbdominalesPrincipiante.this,AbdominalesElevados.class);
        startActivity(infoabelevados);
    }



    public void infolevantamiento(View view)
    {
        Intent infolevantamiento= new Intent(AbdominalesPrincipiante.this,LevantamientoDePiernas.class);
        startActivity(infolevantamiento);
    }

    public void finabprin(View view)
    {
        contador=u.getRutinaAbdomen();
        contador+=1;
        u.setRutinaAbdomen(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}