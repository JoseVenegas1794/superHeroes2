package com.example.sevenegas.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sevenegas.R;
import com.squareup.picasso.Picasso;

public class ActivityDos extends AppCompatActivity {
    String speed2;
    String inteligencia2;
    String fuerza2;
    String nombre;
    String urlSuperHeroe;
    String biografia;
    String alterEgos;
    String placeOfBs;
    int valor;
    int valor2;
    int valor3;
    private ImageView fotoImagenView;
    TextView tx;
    TextView n;
    TextView alterEgo;
    TextView placeOfB;
    ProgressBar velocidad;
    ProgressBar inteligencia;
    TextView progressBar2;
    TextView progressBar3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);


        Ejecuta();

    }

    public void Ejecuta() {
        Bundle extras = getIntent().getExtras();
        biografia = extras.getString("fullName");
        n = (TextView) findViewById(R.id.txtView2);
        n.setText("Nombre Completo: " + biografia);

        nombre = extras.getString("nombre");
        tx = (TextView) findViewById(R.id.txtView1);
        tx.setText("Nombre: " + nombre);
        urlSuperHeroe = extras.getString("imagen");
        fotoImagenView = (ImageView) findViewById(R.id.fotoImagen2);
        Picasso.get().load(urlSuperHeroe).fit().centerCrop().into(fotoImagenView);
        alterEgos = extras.getString("alterEgo");
        alterEgo = (TextView) findViewById(R.id.textView3);
        alterEgo.setText("Alter-egos: " + alterEgos);
        placeOfBs = extras.getString("placeOfB");
        placeOfB = (TextView) findViewById(R.id.textView4);
        placeOfB.setText("Lugar De Nacimiento: " + placeOfBs);


        if (getIntent().hasExtra("speed") == true) {
            try {
                if (getIntent().getStringExtra("speed") == null) {
                } else {
                    speed2 = extras.getString("speed");
                    valor = Integer.parseInt(speed2);
                    velocidad = (ProgressBar) findViewById(R.id.progressBar);
                    velocidad.setProgress(valor);
                    velocidad.setMax(100);
                    progressBar2 = (TextView) findViewById(R.id.txtProgress);
                    progressBar2.setText(valor + "% de 100%");
                }

            } catch (Exception e) {

            }
            progressBar2 = (TextView) findViewById(R.id.txtProgress);
            progressBar2.setText(valor + "% de 100%");

        }
        if (getIntent().hasExtra("intelligence") == true) {
            try {
                if (getIntent().getStringExtra("intelligence") == null) {

                } else {
                    inteligencia2 = extras.getString("intelligence");
                    valor2 = Integer.parseInt(inteligencia2);
                    inteligencia = (ProgressBar) findViewById(R.id.progressBar2);
                    inteligencia.setProgress(valor2);
                    inteligencia.setMax(100);
                    progressBar3 = (TextView) findViewById(R.id.txtProgress2);
                    progressBar3.setText(valor2 + "% de 100%");
                }

            } catch (Exception e) {

            }
            progressBar3 = (TextView) findViewById(R.id.txtProgress2);
            progressBar3.setText(valor2 + "% de 100%");

        }
        if (getIntent().hasExtra("strength") == true) {
            try {
                if (getIntent().getStringExtra("strength") == null) {

                } else {
                    fuerza2 = extras.getString("strength");
                    valor3 = Integer.parseInt(fuerza2);
                    inteligencia = (ProgressBar) findViewById(R.id.progressBar3);
                    inteligencia.setProgress(valor3);
                    inteligencia.setMax(100);
                    progressBar3 = (TextView) findViewById(R.id.txtProgress3);
                    progressBar3.setText(valor3 + "% de 100%");
                }

            } catch (Exception e) {

            }
            progressBar3 = (TextView) findViewById(R.id.txtProgress3);
            progressBar3.setText(valor3 + "% de 100%");

        }
    }
}

