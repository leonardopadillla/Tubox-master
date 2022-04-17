package sv.edu.catolica.workin;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Metabolismobasal extends AppCompatActivity
{
    ////////////////////////////////////////// VARIABLES ///////////////////////////////////////////
    int id =0;
    Usuario u;
    daoUsuario dao;
    TextView alturamb, pesomb, edadmb;
    Button btn_calcular, btn_limpar;
    RadioButton radioButton_masculino, radioButton_femenino, radioButton_leve, radioButton_moderado, radioButton_intenso;
    CheckBox checkBox_semana, checkBox_mes;
    String resultadofinal;
    ////////// VARIAVEIS /////////
    double P, A, I, AF, Resultado, Resultado_semana, Resultado_mes;
    ////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////// FUNÇÃO DE AVISOS EM TELA //////////////////////////////////
    public void alerta(String titulo, String mensagem)
    {
        AlertDialog.Builder alerta = new AlertDialog.Builder(Metabolismobasal.this);

        alerta.setTitle(titulo);
        alerta.setMessage(mensagem);
        alerta.setNeutralButton("OK", null);
        alerta.show();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        /////////////////////////////////////// PADRÃO /////////////////////////////////////////////
        getSupportActionBar().hide();
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_metabolismobasal);
        ////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////// DECLARAÇÕES //////////////////////////////////////////
        alturamb = findViewById(R.id.tvAlturaMB);
        pesomb = findViewById(R.id.tvPesoMB);
        edadmb = findViewById(R.id.tvEdadMB);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        dao = new daoUsuario(this);
        u = dao.getUsuarioById(id);

        alturamb.setText(u.getAltura());
        pesomb.setText(u.getPeso());
        edadmb.setText(u.getEdad());
        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_limpar = (Button) findViewById(R.id.btn_limpiar);

        radioButton_masculino = findViewById(R.id.radioButton_masculino);
        radioButton_femenino = findViewById(R.id.radioButton_femenino);
        radioButton_leve = findViewById(R.id.radioButton_leve);
        radioButton_moderado =  findViewById(R.id.radioButton_moderado);
        radioButton_intenso = findViewById(R.id.radioButton_intenso);

        checkBox_semana = findViewById(R.id.checkBox_semana);
        checkBox_mes =  findViewById(R.id.checkBox_mes);
        ////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////// FUNÇÃO LIMPAR CAMPOS /////////////////////////////////////
        btn_limpar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                radioButton_masculino.setChecked(false);
                radioButton_femenino.setChecked(false);
                radioButton_leve.setChecked(false);
                radioButton_moderado.setChecked(false);
                radioButton_intenso.setChecked(false);

                checkBox_semana.setChecked(false);
                checkBox_mes.setChecked(false);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////

        //////////////////////////////////// Funcion Calcular ///////////////////////////////////////
        btn_calcular.setOnClickListener(new View.OnClickListener()
        {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onClick(View v)
            {
                ////////////////////////// CONDICIONES PARA DATOS EN BLANCO //////////////////////////
                if(
                              alturamb.getText().length() == 0 ||
                                pesomb.getText().length() == 0 ||
                                edadmb.getText().length() == 0 ||
                                (radioButton_masculino.isChecked() == false && radioButton_femenino.isChecked() == false) ||
                                (radioButton_leve.isChecked() == false && radioButton_moderado.isChecked() == false && radioButton_intenso.isChecked() == false))
                {
                    alerta("Aviso", "¡Los datos de altura, peso, edad, sexo y nivel de actividad física deben ser rellenados!");
                    return;
                }
                ////////////////////////////////////////////////////////////////////////////////////

                ///////////////////////////////// CALCULO //////////////////////////////////////////
                else
                {
                    A = Double.parseDouble(alturamb.getText().toString());
                    P = Double.parseDouble(pesomb.getText().toString());
                    I = Double.parseDouble(edadmb.getText().toString());

                    //////////////////////////// SELEÇÃO SE MASCULINO //////////////////////////////
                    if(radioButton_masculino.isChecked())
                    {
                        if(radioButton_leve.isChecked())
                        {
                            AF = 1.55;
                        }
                        if(radioButton_moderado.isChecked())
                        {
                            AF = 1.78;
                        }
                        if(radioButton_intenso.isChecked())
                        {
                            AF = 2.10;
                        }

                        if(checkBox_semana.isChecked() || checkBox_mes.isChecked())
                        {
                            if(checkBox_semana.isChecked() && checkBox_mes.isChecked())
                            {
                                Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                Resultado = Resultado * AF;
                                Resultado_semana = Resultado * 7;
                                Resultado_mes = Resultado * 30;
                                resultadofinal = String.valueOf(Resultado);
                                u.setResultado(resultadofinal);
                                dao.updateUsuario(u);
                                alerta("Tasa Metabólica Basal", "Su TMB es de " +Resultado+ " kcal diárias\nSu TMB es de " +Resultado_semana+ " kcal semanal\nSu TMB es de " +Resultado_mes+ " kcal mensual");
                                Intent in = new Intent(Metabolismobasal.this, Login.class);
                                in.putExtra("id",u.getId());
                                startActivity(in);
                                finish();
                                return;
                            }

                            if(checkBox_semana.isChecked())
                            {
                                Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                Resultado = Resultado * AF;
                                Resultado_semana = Resultado * 7;
                                resultadofinal = String.valueOf(Resultado);
                                u.setResultado(resultadofinal);
                                dao.updateUsuario(u);
                                alerta("Tasa Metabólica Basal", "Su TMB es de " +Resultado+ " kcal diárias\nSu TMB es de " +Resultado_semana+ " kcal semanal");
                                Intent in = new Intent(Metabolismobasal.this, Login.class);
                                in.putExtra("id",u.getId());
                                startActivity(in);
                                finish();
                                return;
                            }

                            if(checkBox_mes.isChecked())
                            {
                                Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                                Resultado = Resultado * AF;
                                Resultado_mes = Resultado * 30;
                                resultadofinal = String.valueOf(Resultado);
                                u.setResultado(resultadofinal);
                                dao.updateUsuario(u);
                                alerta("Tasa Metabólica Basal", "Su TMB es de " +Resultado+ " kcal diárias\nSu TMB es de " +Resultado_mes+ " kcal mensual");
                                Intent in = new Intent(Metabolismobasal.this, Login.class);
                                in.putExtra("id",u.getId());
                                startActivity(in);
                                finish();
                                return;
                            }
                        }
                        else
                        {
                            Resultado = 66.5 + (14 * P) + (5 * A) - (6.7 * I);
                            Resultado = Resultado * AF;
                            resultadofinal = String.valueOf(Resultado);
                            u.setResultado(resultadofinal);
                            dao.updateUsuario(u);
                            alerta("Tasa Metabólica Basal", "Su TMB es de " +Resultado+ " kcal diárias");
                            Intent in = new Intent(Metabolismobasal.this, Login.class);
                            in.putExtra("id",u.getId());
                            startActivity(in);
                            finish();
                            return;
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////

                    ///////////////////////////// FEMENINO //////////////////////////////
                    else
                    {
                        if(radioButton_leve.isChecked())
                        {
                            AF = 1.56;
                        }
                        if(radioButton_moderado.isChecked())
                        {
                            AF = 1.64;
                        }
                        if(radioButton_intenso.isChecked())
                        {
                            AF = 1.82;
                        }

                        if(checkBox_semana.isChecked() || checkBox_mes.isChecked())
                        {
                            if(checkBox_semana.isChecked() && checkBox_mes.isChecked())
                            {
                                Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                Resultado = Resultado * AF;
                                Resultado_semana = Resultado * 7;
                                Resultado_mes = Resultado * 30;
                                resultadofinal = String.valueOf(Resultado);
                                u.setResultado(resultadofinal);
                                dao.updateUsuario(u);
                                alerta("Tasa Metabólica Basal", "Su TMB es de " +Resultado+ " kcal diárias\nSu TMB es de " +Resultado_semana+ " kcal semanal\nSu TMB es de " +Resultado_mes+ " kcal mensal");
                                return;
                            }

                            if(checkBox_semana.isChecked())
                            {
                                Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                Resultado = Resultado * AF;
                                Resultado_semana = Resultado * 7;
                                resultadofinal = String.valueOf(Resultado);
                                u.setResultado(resultadofinal);
                                dao.updateUsuario(u);
                                alerta("Tasa Metabólica Basal", "Su TMB es de " +Resultado+ " kcal diárias\nSu TMB es de " +Resultado_semana+ " kcal semanal");
                                return;
                            }

                            if(checkBox_mes.isChecked())
                            {
                                Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                                Resultado = Resultado * AF;
                                Resultado_mes = Resultado * 30;
                                resultadofinal = String.valueOf(Resultado);
                                u.setResultado(resultadofinal);
                                dao.updateUsuario(u);
                                alerta("Tasa Metabólica Basal", "Su TMB es de " +Resultado+ " kcal diárias\nSu TMB es de " +Resultado_mes+ " kcal mensual");
                                return;
                            }
                        }
                        else
                        {
                            Resultado = 65.5 + (9.6 * P) + (1.8 * A) - (4.7 * I);
                            Resultado = Resultado * AF;
                            resultadofinal = String.valueOf(Resultado);
                            u.setResultado(resultadofinal);
                            dao.updateUsuario(u);
                            alerta("Tasa Metabólica Basal", "Su TMB es de " +Resultado+ " kcal diárias");;
                            return;
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////
                }
                ////////////////////////////////////////////////////////////////////////////////////
                resultadofinal = String.valueOf(Resultado);
                u.setResultado(resultadofinal);
                dao.updateUsuario(u);


            }

        });
        ////////////////////////////////////////////////////////////////////////////////////////////
    }
}