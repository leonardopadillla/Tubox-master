package sv.edu.catolica.workin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Resgistrarse extends AppCompatActivity implements View.OnClickListener {

    EditText us;
    EditText pas;
    EditText col;
    EditText repass;
    EditText alt;
    EditText pes;
    EditText edd;
    EditText cod;
    Button reg;
    daoUsuario dao;
    String codigofinalgym;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.design_registro);

        us=(EditText)findViewById(R.id.etUserNuevo);
        pas=(EditText)findViewById(R.id.etPasswordNuevo);
        repass=(EditText)findViewById(R.id.etPasswordNuevo);
        reg = (Button)findViewById(R.id.btnEnviar);
        alt= findViewById(R.id.etaltura);
        pes=findViewById(R.id.etPeso);
        edd=findViewById(R.id.etEdad);
        cod=findViewById(R.id.codigogym);
        reg.setOnClickListener(this);


        dao=new daoUsuario(this);
    }
    public void Enviar(View view)
    {
        Intent login= new Intent(Resgistrarse.this,Login.class);
        startActivity(login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEnviar:
                Usuario u = new Usuario();
                u.setNombre(us.getText().toString());
                u.setPersonalizada("0");
                u.setPassword(pas.getText().toString());
                u.setAltura(alt.getText().toString());
                u.setPeso(pes.getText().toString());
                u.setEdad(edd.getText().toString());
                u.setResultado("0");
                u.setRutinaAbdomen(0);
                u.setRutinaBrazo(0);
                u.setRutinaPecho(0);
                u.setRutinaPiernas(0);
                u.setRutinaTodoCuerpo(0);
                String c =  cod.getText().toString();
                String codigof = "tubox123";
                if (!u.isNull()&&c.equals("")){
                    Toast.makeText( this, "ERROR: Campos vacíos o no ha introducido el codigo correctamente", Toast.LENGTH_SHORT).show();
                }else if(pas.getText().toString().equals(repass.getText().toString())&&c.equals(codigof)){
                    if(dao.insertUsuario(u)) {
                        Toast.makeText(this, "Registro Exitoso!", Toast.LENGTH_SHORT).show();
                        Intent enviar = new Intent(Resgistrarse.this, Login.class);
                        startActivity(enviar);
                        finish();
                    }else{
                        Toast.makeText( this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                        }
                }
                else {
                    Toast.makeText( this, "Usuario ya registrado o codigo invalido", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}
