package sv.edu.catolica.workin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

public class Dietas extends AppCompatActivity {
    private TextView link1, link2,link3,link4;
    private String url1,url2,url3,url4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_dietas);

        SpannableStringBuilder builder = new SpannableStringBuilder();

        link1 = findViewById(R.id.tv_2);
        link2 = findViewById(R.id.tv_4);
        link3 = findViewById(R.id.tv_7);
        link4 = findViewById(R.id.tv_9);
        url1 = "https://www.ensure.abbott/gt/alimentacion/para-evitar-la-perdida-muscular.html";
        url2 = "https://www.tuasaude.com/es/dieta-para-aumentar-la-masa-muscular/";
        url3 = "https://www.ensure.abbott/gt/alimentacion/para-ser-mas-saludables.html";
        url4 = "https://www.niddk.nih.gov/health-information/informacion-de-la-salud/diabetes/informacion-general/nutricion-alimentacion-actividad-fisica";

        String red = "Para mayor inf.";
        SpannableString redSpannable= new SpannableString(red);
        redSpannable.setSpan(new ForegroundColorSpan(Color.WHITE), 0, red.length(), 0);
        builder.append(redSpannable);

        String white = "Click Aquí";
        SpannableString whiteSpannable= new SpannableString(white);
        whiteSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.boton)), 0, white.length(), 0);
        builder.append(whiteSpannable);

        link1.setText(builder, TextView.BufferType.SPANNABLE);

        link2.setText(builder, TextView.BufferType.SPANNABLE);

        link3.setText(builder, TextView.BufferType.SPANNABLE);

        link4.setText(builder, TextView.BufferType.SPANNABLE);

        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse((url1));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri2 = Uri.parse((url2));
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);
            }
        });

        link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri3 = Uri.parse((url3));
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                startActivity(intent3);
            }
        });

        link4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri4 = Uri.parse((url4));
                Intent intent4 = new Intent(Intent.ACTION_VIEW, uri4);
                startActivity(intent4);
            }
        });
    }
}