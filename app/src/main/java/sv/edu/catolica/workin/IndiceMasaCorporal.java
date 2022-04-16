package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class IndiceMasaCorporal extends AppCompatActivity {
    double imc, pes, alt, altr, altr2, altr3;
    TextView indice;
    int id =0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desing_indicemasacorporal);

        indice=findViewById(R.id.tvIndice);

        Bundle bundle = getIntent().getExtras();
        id=bundle.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);

        pes=  Double.parseDouble(u.getPeso());
        alt= Double.parseDouble(u.getAltura());

        altr = alt*30.48;
        altr2= altr/100;
        altr3= altr2*altr2;
        imc = pes/altr3;


        indice.setText("IMC: "+String.format("%.2f",imc));

    }


}