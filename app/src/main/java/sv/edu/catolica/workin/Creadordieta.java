package sv.edu.catolica.workin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Creadordieta extends AppCompatActivity implements View.OnClickListener {
    Button ress6,ress4, ress5;
    String eliminarresultado;
    int id = 0;
    Usuario u;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_creadordieta);
        ress6 = findViewById(R.id.restablecer6);
        ress5 = findViewById(R.id.restablecer5);
        ress4 = findViewById(R.id.restablecer4);



        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        dao = new daoUsuario(this);
        u = dao.getUsuarioById(id);


        ress6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.restablecer6:
                        Intent intent = new Intent(Creadordieta.this, Metabolismobasal.class);
                        intent.putExtra("id", u.getId());
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });
        ress5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.restablecer5:
                        Intent intent = new Intent(Creadordieta.this, Creardieta.class);
                        intent.putExtra("id", u.getId());
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });
        ress4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarresultado="0";
                u.setResultado(eliminarresultado);
                dao.updateUsuario(u);
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Se elimino su dieta exitosamente", Toast.LENGTH_SHORT);
                toast1.show();
                Intent in = new Intent(Creadordieta.this, Login.class);
                in.putExtra("id",u.getId());
                startActivity(in);
                finish();
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.restablecer6:
                Intent intent = new Intent(Creadordieta.this, Creardieta.class);
                intent.putExtra("id", u.getId());
                startActivity(intent);
                finish();
                break;
        }
    }
}