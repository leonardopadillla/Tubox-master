package sv.edu.catolica.workin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RestablecerAltura extends AppCompatActivity implements View.OnClickListener {
    EditText alt, alt2;
    Button save1;
    int id=0;
    Usuario u;
    daoUsuario dao;
    String colorsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.design_restableceraltura);

        alt= findViewById(R.id.etAlturaNueva);
        alt2= findViewById(R.id.etAlturaComprobacion);
        save1= findViewById(R.id.btnGuardar1);
        save1.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        colorsi=u.getColorFav();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar1:
                u.setAltura(alt.getText().toString());
                if(!u.isNull()&& alt!=alt2) {
                    Toast.makeText(this, "ERROR: Campos vacíos o contraseñas no coinciden",
                            Toast.LENGTH_SHORT).show();
                }else if (dao.updateUsuario(u)){

                    Toast.makeText(this, "Actualización Exitosa!", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(RestablecerAltura.this, Login.class);
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
