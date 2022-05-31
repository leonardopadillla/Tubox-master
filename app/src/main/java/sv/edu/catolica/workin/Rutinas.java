package sv.edu.catolica.workin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Rutinas extends AppCompatActivity {
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_rutinas);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
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
                Intent home = new Intent(Rutinas.this, HomeRutinas.class);
                startActivity(home);
                break;
            case R.id.perfil:
                Intent perfi = new Intent(Rutinas.this, Perfil.class);
                startActivity(perfi);
                break;
            case R.id.about:
                Intent acercad = new Intent(Rutinas.this, AboutUs.class);
                startActivity(acercad);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void AbPrincipiante(View view)
    {
        Intent abprin= new Intent(Rutinas.this,AbdominalesPrincipiante.class);
        abprin.putExtra("id",u.getId());
        startActivity(abprin);
    }

    public void AbIntermedio(View view)
    {
        Intent abintermedio= new Intent(Rutinas.this,AbdominalesIntermedio.class);
        abintermedio.putExtra("id",u.getId());
        startActivity(abintermedio);
    }

    public void AbAvanzado(View view)
    {
        Intent abavanzado= new Intent(Rutinas.this,AbdominalesAvanzados.class);
        abavanzado.putExtra("id",u.getId());
        startActivity(abavanzado);
    }

    public void PecPrincipiante(View view)
    {
        Intent pecprincipiante= new Intent(Rutinas.this,PectoralPrincipiante.class);
        pecprincipiante.putExtra("id",u.getId());
        startActivity(pecprincipiante);
    }

    public void PecIntermedio(View view)
    {
        Intent pecintermedio= new Intent(Rutinas.this,PectoralIntermedio.class);
        pecintermedio.putExtra("id",u.getId());
        startActivity(pecintermedio);
    }

    public void PecAvanzado(View view)
    {
        Intent pecavanzado= new Intent(Rutinas.this,PectoralesAvanzado.class);
        pecavanzado.putExtra("id",u.getId());
        startActivity(pecavanzado);
    }

    public void PiernasPrinc(View view)
    {
        Intent pierprin= new Intent(Rutinas.this,PiernasPrincipiante.class);
        pierprin.putExtra("id",u.getId());
        startActivity(pierprin);
    }

    public void PiernasInter(View view)
    {
        Intent pierinter= new Intent(Rutinas.this,PiernasIntermedio.class);
        pierinter.putExtra("id",u.getId());
        startActivity(pierinter);
    }

    public void PiernasAvan(View view)
    {
        Intent pieravan= new Intent(Rutinas.this,PiernasAvanzado.class);
        pieravan.putExtra("id",u.getId());
        startActivity(pieravan);
    }

    public void BrazosPrin(View view)
    {
        Intent brazosprin= new Intent(Rutinas.this,BrazosPrincipiante.class);
        brazosprin.putExtra("id",u.getId());
        startActivity(brazosprin);
    }

    public void BrazosInter(View view)
    {
        Intent brazosinter= new Intent(Rutinas.this,BrazosIntermedio.class);
        brazosinter.putExtra("id",u.getId());
        startActivity(brazosinter);
    }

    public void BrazosAvan(View view)
    {
        Intent brazoavan = new Intent(Rutinas.this,BrazosAvanzado.class);
        brazoavan.putExtra("id",u.getId());
        startActivity(brazoavan);
    }

    public void cueroPrincipiante(View view)
    {
        Intent cuerpop = new Intent(Rutinas.this,TodoCuerpoPrincipiante.class);
        cuerpop.putExtra("id",u.getId());
        startActivity(cuerpop);
    }

    public void cuerpoIntermedio(View view)
    {
        Intent cuerpoi = new Intent(Rutinas.this,TodoCuerpoIntermedio.class);
        cuerpoi.putExtra("id",u.getId());
        startActivity(cuerpoi);
    }
    public void wod5avanzadorutina(View view)
    {
        Intent cuerpoa = new Intent(Rutinas.this,Wod5Avanzado.class);
        cuerpoa.putExtra("id",u.getId());
        startActivity(cuerpoa);
    }


}