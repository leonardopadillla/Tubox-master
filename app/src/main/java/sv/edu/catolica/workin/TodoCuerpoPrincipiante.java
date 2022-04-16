package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TodoCuerpoPrincipiante extends AppCompatActivity {
    Button btnTerminar;
    int contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rutina_todo_cuerpo_principiante);

        btnTerminar=findViewById(R.id.btnTCconcluirPrin);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }



    public void infoplancha(View view) {
        Intent infobur= new Intent(TodoCuerpoPrincipiante.this,Plancha.class);
        startActivity(infobur);
    }


    public void concluirEntreno(View view) {
        contador=u.getRutinaTodoCuerpo();
        contador+=1;
        u.setRutinaTodoCuerpo(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}