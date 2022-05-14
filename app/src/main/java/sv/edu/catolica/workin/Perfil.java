package sv.edu.catolica.workin;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Perfil extends AppCompatActivity implements View.OnClickListener {
    TextView nombre, estatura, peso, edad, calorias, progressAb, progressP, progressPecho, progressBrazo, progressTC;
    Button ress, ress1, ress2, ress3,ress4, ress5;
    ProgressBar pb;
    int id = 0;
    Usuario u;
    daoUsuario dao;
    //Para la notificacion.
    Button selechora, guardar, selecdia;
    TextView tvhora, tvdia;

    Calendar actual = Calendar.getInstance();
    Calendar calendar = Calendar.getInstance();
    String eliminarresultado;
    Double llamarresultado;

    private int minutos, hora, dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.design_perfil);

        nombre = findViewById(R.id.tvNombreUsuario);
        peso = findViewById(R.id.tvPeso);
        estatura = findViewById(R.id.tvEstatura);
        edad = findViewById(R.id.tvEdad);
        calorias = findViewById(R.id.tvResultado);
        progressAb = findViewById(R.id.tvprogressAb);
        progressP = findViewById(R.id.tvprogressPecho);
        progressPecho = findViewById(R.id.tvprogressPierna);
        progressBrazo = findViewById(R.id.tvprogressbrazo);
        progressTC = findViewById(R.id.tvprogressTodoCuerpo);
        ress = findViewById(R.id.restablecer);
        ress.setOnClickListener(this);
        ress1 = findViewById(R.id.restablecer1);
        ress2 = findViewById(R.id.restablecer2);
        ress3 = findViewById(R.id.restablecer3);
        ress4 = findViewById(R.id.restablecer4);
        ress5 = findViewById(R.id.restablecer5);


        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        dao = new daoUsuario(this);
        u = dao.getUsuarioById(id);

        nombre.setText(u.getNombre());
        estatura.setText(u.getAltura());
        peso.setText(u.getPeso());
        edad.setText(u.getEdad());
        llamarresultado= Double.parseDouble(u.getResultado());

        if (llamarresultado >0 && llamarresultado <=1){
            calorias.setText("Calorias sin calcular");
        }
        else {calorias.setText(u.getResultado());}

        progressAb.setText("Número de rutinas Wod 1 completadas satisfactoriamente: " + u.getRutinaAbdomen());
        progressP.setText("Número de rutinas Wod 2 completadas satisfactoriamente: " + u.getRutinaPecho());
        progressPecho.setText("Número de rutinas Wod 3 completadas satisfactoriamente: " + u.getRutinaPiernas());
        progressBrazo.setText("Número de rutinas Wod 4 completadas satisfactoriamente: " + u.getRutinaBrazo());
        progressTC.setText("Número de rutinas Wod 5 completadas satisfactoriamente: " + u.getRutinaTodoCuerpo());

        selechora = findViewById(R.id.btnhorario);
        guardar = findViewById(R.id.btnguardaralarma);
        tvhora = findViewById(R.id.tvhora);
        tvdia = findViewById(R.id.tvdias);
        selecdia = findViewById(R.id.btseleccionedia);

        selechora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hora = actual.get(Calendar.HOUR_OF_DAY);
                minutos = actual.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(v.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int h, int m) {
                        calendar.set(Calendar.HOUR_OF_DAY, h);
                        calendar.set(Calendar.MINUTE, m);
                        tvhora.setText(String.format("%02d:%02d", h, m));
                    }
                }, hora, minutos, true);
                timePickerDialog.show();
            }
        });

        selecdia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dia = actual.get(Calendar.DAY_OF_WEEK);
                AlertDialog.Builder window = new AlertDialog.Builder(Perfil.this);
                window.setTitle("Seleccione los dias para entrenar");
                final String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
                boolean[] chekeditems = {false, false, false, false, false, false, false};
                final List<String> diaslist = Arrays.asList(dias);
                window.setMultiChoiceItems(dias, chekeditems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        chekeditems[i] = b;
                        String currentitem = diaslist.get(i);
                    }
                });
                window.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvdia.setText("");
                        for (int x = 0; x < chekeditems.length; x++) {
                            boolean checked = chekeditems[x];
                            if (checked) {
                                tvdia.setText(tvdia.getText() + " -" + diaslist.get(x));
                            }
                        }
                    }
                });
                window.create();
                window.show();
            }

        });


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = generateKey();
                Long AlertTime = calendar.getTimeInMillis() - System.currentTimeMillis();
                int random = (int) (Math.random() * 50 + 1);
                Data data = GuardarDatos("WorkIn", "Es hora de entrenar", random);
                WorkManagerNoti.Guardarnoti(AlertTime, data, tag);


                Toast.makeText(Perfil.this, "Alarma Guardada.", Toast.LENGTH_SHORT).show();
            }
        });
        ress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.restablecer1:
                        Intent intent = new Intent(Perfil.this, RestablecerAltura.class);
                        intent.putExtra("id", u.getId());
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });

        ress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.restablecer2:
                        Intent intent = new Intent(Perfil.this, RestablecerPeso.class);
                        intent.putExtra("id", u.getId());
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });
        ress3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.restablecer3:
                        Intent intent = new Intent(Perfil.this, RestablecerEdad.class);
                        intent.putExtra("id", u.getId());
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });
        ress4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarresultado="0";
                u.setResultado(eliminarresultado);
                dao.updateUsuario(u);
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Se elimino su dieta exitosamente", Toast.LENGTH_SHORT);
                toast1.show();
                Intent in = new Intent(Perfil.this, Login.class);
                in.putExtra("id",u.getId());
                startActivity(in);
                finish();
            }
        });
        ress5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.restablecer5:
                        Intent intent = new Intent(Perfil.this, Creardieta.class);
                        intent.putExtra("id", u.getId());
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });


    }

    private String generateKey() {
        return UUID.randomUUID().toString();
    }

    private Data GuardarDatos(String titulo, String detalle, int idnoti) {
        return new Data.Builder()
                .putString("titulo", titulo)
                .putString("detalle", detalle)
                .putInt("idnoti", idnoti).build();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.restablecer:
                Intent intent = new Intent(Perfil.this, RestablecerContrasena.class);
                intent.putExtra("id", u.getId());
                startActivity(intent);
                finish();
                break;
        }
    }



}
