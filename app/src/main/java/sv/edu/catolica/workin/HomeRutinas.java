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
        if (ResultadoDieta >= 1 &&  ResultadoDieta< 2) {
            Intent dietaper= new Intent(HomeRutinas.this,DietaPer.class);
            dietaper.putExtra("id",u.getId());
            startActivity(dietaper);
        }
        else if (ResultadoDieta > 2 &&  ResultadoDieta< 1599) {
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
        else if (ResultadoDieta > 2000 &&  ResultadoDieta< 2099) {
            Intent dieta2000= new Intent(HomeRutinas.this,Dieta2000.class);
            startActivity(dieta2000);
        }
        else if (ResultadoDieta > 2100 &&  ResultadoDieta< 2199) {
            Intent dieta2100= new Intent(HomeRutinas.this,Dieta2100.class);
            startActivity(dieta2100);
        }
        else if (ResultadoDieta > 2200 &&  ResultadoDieta< 2299) {
            Intent dieta2200= new Intent(HomeRutinas.this,Dieta2200.class);
            startActivity(dieta2200);
        }
        else if (ResultadoDieta > 2300 &&  ResultadoDieta< 2399) {
            Intent dieta2300= new Intent(HomeRutinas.this,Dieta2300.class);
            startActivity(dieta2300);
        }
        else if (ResultadoDieta > 2400 &&  ResultadoDieta< 2499) {
            Intent dieta2400= new Intent(HomeRutinas.this,Dieta2400.class);
            startActivity(dieta2400);
        }
        else if (ResultadoDieta > 2500) {
            Intent dieta2500= new Intent(HomeRutinas.this,Dieta2500.class);
            startActivity(dieta2500);
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

    public void iricd(View view)
    {
        Intent icd= new Intent(HomeRutinas.this,Creadordieta.class);
        icd.putExtra("id",u.getId());
        startActivity(icd);
    }


    public void irconsejos(View view)
    {
        Intent consejos= new Intent(HomeRutinas.this,Consejos.class);
        startActivity(consejos);
    }
}
