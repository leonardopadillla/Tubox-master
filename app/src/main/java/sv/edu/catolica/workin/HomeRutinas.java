package sv.edu.catolica.workin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class HomeRutinas extends AppCompatActivity{
    int id =0;
    Usuario u;
    daoUsuario dao;
    String ResultadoD;
    Double ResultadoDieta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.design_home);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        ResultadoD = u.getResultado();
        ResultadoDieta = Double.parseDouble(ResultadoD);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.home:
                Intent home = new Intent(HomeRutinas.this, HomeRutinas.class);
                startActivity(home);
                break;
            case R.id.perfil:
                Intent perfi = new Intent(HomeRutinas.this, Perfil.class);
                perfi.putExtra("id",u.getId());
                startActivity(perfi);
                break;
            case R.id.about:
                Intent acercad = new Intent(HomeRutinas.this, AboutUs.class);
                startActivity(acercad);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void irrutinas(View view)
    {
        Intent rutinas= new Intent(HomeRutinas.this,Rutinas.class);
        rutinas.putExtra("id",u.getId());
        startActivity(rutinas);
    }

    public void irdietas(View view)
    {
        if (ResultadoDieta > 1 &&  ResultadoDieta< 1599) {
            Intent dieta1500= new Intent(HomeRutinas.this,Dieta1500.class);
            startActivity(dieta1500);
        }
        else if (ResultadoDieta > 1600 &&  ResultadoDieta< 1699) {
            Intent dieta1600= new Intent(HomeRutinas.this,Dieta1600.class);
            startActivity(dieta1600);
        }
        else if (ResultadoDieta > 1700 &&  ResultadoDieta< 1799) {
            Intent dieta1700= new Intent(HomeRutinas.this,Dieta1700.class);
            startActivity(dieta1700);
        }
        else if (ResultadoDieta > 1800 &&  ResultadoDieta< 1899) {
            Intent dieta1800= new Intent(HomeRutinas.this,Dieta1800.class);
            startActivity(dieta1800);
        }
        else if (ResultadoDieta > 1900 &&  ResultadoDieta< 1999) {
            Intent dieta1900= new Intent(HomeRutinas.this,Dieta1900.class);
            startActivity(dieta1900);
        }
        else {
            Intent dietas= new Intent(HomeRutinas.this,Dietas.class);
            startActivity(dietas);
        }

    }

    public void irimc(View view)
    {
        Intent imc= new Intent(HomeRutinas.this,IndiceMasaCorporal.class);
        imc.putExtra("id",u.getId());
        startActivity(imc);
    }
    public void irimb(View view)
    {
        Intent imb= new Intent(HomeRutinas.this,Metabolismobasal.class);
        imb.putExtra("id",u.getId());
        startActivity(imb);
    }

    public void irconsejos(View view)
    {
        Intent consejos= new Intent(HomeRutinas.this,Consejos.class);
        startActivity(consejos);
    }
}
