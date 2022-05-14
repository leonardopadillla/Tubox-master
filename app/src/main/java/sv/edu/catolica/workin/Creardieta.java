package sv.edu.catolica.workin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Creardieta extends AppCompatActivity implements View.OnClickListener {
    EditText personalizadaf;
    Button save5;
    int id=0;
    Usuario u;
    daoUsuario dao;
    String insertarcaloria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.design_creardieta);

        personalizadaf= findViewById(R.id.etDietaper);
        save5= findViewById(R.id.btnGuardar5);
        save5.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar5:
                insertarcaloria="1";
                u.setResultado(insertarcaloria);
                u.setPersonalizada(personalizadaf.getText().toString());
                if(!u.isNull()) {
                    Toast.makeText(this, "ERROR: Campos vacíos  no coinciden",
                            Toast.LENGTH_SHORT).show();
                }else if (dao.updateUsuario(u)){

                    Toast.makeText(this, "Actualización Exitosa!", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(Creardieta.this, Login.class);
                    in.putExtra("id",u.getId());
                    startActivity(in);
                    finish();
                }else{
                    Toast.makeText(this, "No se puede actualizar", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}




