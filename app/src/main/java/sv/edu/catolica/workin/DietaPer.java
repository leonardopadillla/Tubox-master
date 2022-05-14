package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DietaPer extends AppCompatActivity {
    TextView dietapropia;
    int id =0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dietaper);
        dietapropia=findViewById(R.id.tvDietapersonalizada);
        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        dietapropia.setText(u.getPersonalizada());

    }


}