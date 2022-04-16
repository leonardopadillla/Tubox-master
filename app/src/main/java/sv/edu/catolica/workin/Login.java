package sv.edu.catolica.workin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText nombreuser, pass;
    Button btnIngresar, btnRegistrar;
    daoUsuario dao;
    TextView resta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_user);

        nombreuser=(EditText)findViewById(R.id.etUser);
        pass=(EditText)findViewById(R.id.etPassword);
        btnIngresar = (Button)findViewById(R.id.btnIngresar);
        btnRegistrar = (Button)findViewById(R.id.btnRegistrarse);
        btnIngresar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao=new daoUsuario(this);

    }

    @Override
    public void onClick(View v) {
        String u = nombreuser.getText().toString();
        String p = pass.getText().toString();
        switch (v.getId()){
            case R.id.btnIngresar:

                if (u.equals("")&&p.equals("")){
                    Toast.makeText(this, "ERROR: Campos vacíos", Toast.LENGTH_SHORT).show();
                }else if (dao.login(u,p)==1){
                    Usuario ux  = dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
                    Intent in= new Intent(Login.this,HomeRutinas.class);
                    in.putExtra("id",ux.getId());
                    startActivity(in);
                    finish();

                }else{
                    Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRegistrarse:
                Intent registro= new Intent(Login.this,Resgistrarse.class);
                startActivity(registro);

                break;
            /*case R.id.tvRestablecerContraseña:
                Usuario ux  = dao.getUsuario(u,p);
                Intent restablecer= new Intent(Login.this,RestablecerContrasena.class);
                restablecer.putExtra("id",ux.getId());
                startActivity(restablecer);*/
        }
    }

    /*public void restablecercontra(View view)
    {
        Intent restablecer= new Intent(Login.this,RestablecerContrasena.class);
        startActivity(restablecer);
    }*/
}
