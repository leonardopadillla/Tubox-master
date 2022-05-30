package sv.edu.catolica.workin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText nombreuser, pass;
    TextView lblrecuperacion;
    Button btnIngresar, btnRegistrar;
    daoUsuario dao;
    TextView resta;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_user);
        Bundle bundle = getIntent().getExtras();
        nombreuser = (EditText) findViewById(R.id.etUser);
        pass = (EditText) findViewById(R.id.etPassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrarse);
        lblrecuperacion = findViewById(R.id.recuperacionloginlbl);
        btnIngresar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        lblrecuperacion.setOnClickListener(this);
        dao = new daoUsuario(this);

    }

    @Override
    public void onClick(View v) {
        String u = nombreuser.getText().toString();
        String p = pass.getText().toString();
        String c = lblrecuperacion.getText().toString();

        switch (v.getId()) {
            case R.id.btnIngresar:

                if (u.equals("") && p.equals("")) {
                    Toast.makeText(this, "ERROR: Campos vacíos", Toast.LENGTH_SHORT).show();
                } else if (dao.login(u, p) == 1) {
                    Usuario ux = dao.getUsuario(u, p);
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(Login.this, HomeRutinas.class);
                    in.putExtra("id", ux.getId());
                    startActivity(in);
                    finish();

                } else {
                    Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRegistrarse:
                Intent registro = new Intent(Login.this, Resgistrarse.class);
                startActivity(registro);

                break;
            case R.id.recuperacionloginlbl:
                Usuario ul = dao.getUsuariorecover(u);
                if (ul!=null) {
                    Intent recu = new Intent(Login.this, RecuperacionPass.class);
                    recu.putExtra("id", ul.getId());
                    startActivity(recu);

                }
                else {
                    Toast.makeText(this, "Ingrese un usuario y despues clickee recuperar", Toast.LENGTH_SHORT).show();
                }


        }
    }
}