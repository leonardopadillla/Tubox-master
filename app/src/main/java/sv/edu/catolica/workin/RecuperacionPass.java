package sv.edu.catolica.workin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperacionPass extends AppCompatActivity implements View.OnClickListener {
    EditText pas,  color;
    Button save;
    int id=0;
    Usuario u;
    daoUsuario dao;
    String colorbase, colorfinal, passreal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.design_recuperarpass);
        color= findViewById(R.id.etColorfavoritorecu);
        pas= findViewById(R.id.etContrasenanuevarecuperacio);
        save= findViewById(R.id.btnGuardarcon);
        save.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        Log.d("UsuarioObtenido", u.toString());
        colorbase=u.getColorfav();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardarcon:
                u.setPassword(pas.getText().toString());

                if(!colorbase.equalsIgnoreCase(color.getText().toString())) {
                    Toast.makeText(this, "ERROR: Campos vacíos o el color esta erroneo",
                            Toast.LENGTH_SHORT).show();
                }else if (dao.updateUsuario(u)){

                    Toast.makeText(this, "Actualización Exitosa!", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(RecuperacionPass.this, Login.class);
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