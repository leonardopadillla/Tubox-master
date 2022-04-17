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
        if (ResultadoDieta < 1400) {
            Intent dieta1500= new Intent(HomeRutinas.this,Dieta1500.class);
            startActivity(dieta1500);
        } else {
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
