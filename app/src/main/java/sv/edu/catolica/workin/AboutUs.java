package sv.edu.catolica.workin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity{

    Usuario u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.design_aboutus);

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
                Intent home = new Intent(AboutUs.this, HomeRutinas.class);
                startActivity(home);
                break;
            case R.id.perfil:
                Intent perfi = new Intent(AboutUs.this, Perfil.class);
                perfi.putExtra("id",u.getId());
                startActivity(perfi);
                break;
            case R.id.about:
                Intent acercad = new Intent(AboutUs.this, AboutUs.class);
                startActivity(acercad);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
