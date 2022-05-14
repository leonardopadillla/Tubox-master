package sv.edu.catolica.workin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RestablecerEdad extends AppCompatActivity implements View.OnClickListener {
    EditText edd, edd2;
    Button save3;
    int id=0;
    Usuario u;
    daoUsuario dao;
    String personalizadasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.design_restableceredad);

        edd= findViewById(R.id.etPesoNuevo);
        edd2= findViewById(R.id.etPesoComprobacion);
        save3= findViewById(R.id.btnGuardar4);
        save3.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        personalizadasi=u.getPersonalizada();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar4:
                u.setEdad(edd.getText().toString());
                if(!u.isNull()&& edd!=edd2) {
                    Toast.makeText(this, "ERROR: Campos vacíos  no coinciden",
                            Toast.LENGTH_SHORT).show();
                }else if (dao.updateUsuario(u)){

                    Toast.makeText(this, "Actualización Exitosa!", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(RestablecerEdad.this, Login.class);
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
