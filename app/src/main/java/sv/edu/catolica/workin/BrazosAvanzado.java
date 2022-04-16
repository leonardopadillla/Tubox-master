package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BrazosAvanzado extends AppCompatActivity {
    Button btnTerminar;
    int contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rutina_brazos_avanzado);

        btnTerminar=findViewById(R.id.btnbrazoconcluirAvanzado);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }

    public void infotijera(View view)
    {
        Intent infotijera= new Intent(BrazosAvanzado.this,SaltoTijera.class);
        startActivity(infotijera);
    }

    public void infoflexiones(View view)
    {
        Intent infoflexiones= new Intent(BrazosAvanzado.this,Flexiones.class);
        startActivity(infoflexiones);
    }

    public void infoflexionpared(View view)
    {
        Intent infoflexionpared= new Intent(BrazosAvanzado.this,FlexionContraPared.class);
        startActivity(infoflexionpared);
    }
    public void finentrenamientoBrazoava(View view)
    {
        contador=u.getRutinaBrazo();
        contador+=1;
        u.setRutinaBrazo(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}