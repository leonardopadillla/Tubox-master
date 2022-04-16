package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TodoCuerpoIntermedio extends AppCompatActivity {
    Button btnTerminar;
    int contador;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_todo_cuerpo_intermedio);

        btnTerminar=findViewById(R.id.btnTCconcluirInter);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
    }



    public void infoplancha(View view) {
        Intent infop= new Intent(TodoCuerpoIntermedio.this,Plancha.class);
        startActivity(infop);
    }



    public void concluirEntroIntermedio(View view) {
        contador=u.getRutinaTodoCuerpo();
        contador+=1;
        u.setRutinaTodoCuerpo(contador);
        dao.updateUsuario(u);
        Toast.makeText(this, "Felicidades! Ha concluído con su entrenamiento.", Toast.LENGTH_SHORT).show();
        finish();
    }
}