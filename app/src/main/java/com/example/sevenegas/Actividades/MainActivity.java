package com.example.sevenegas.Actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sevenegas.R;
import com.example.sevenegas.Entidades.SuperHeroe;
import com.example.sevenegas.Adapter.SuperHeroeApiService;
import com.example.sevenegas.Adapter.SuperHeroeRespuesta;
import com.example.sevenegas.Adapter.listaHeroesAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
private Retrofit retrofit;
private TextView resp;
    private com.example.sevenegas.Adapter.listaHeroesAdapter listaHeroesAdapter;

private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        listaHeroesAdapter = new listaHeroesAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this,4, GridLayoutManager.VERTICAL,true);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listaHeroesAdapter);

        //resp = (TextView) findViewById(R.id.txt);
        retrofit = new Retrofit.Builder().baseUrl("https://www.superheroapi.com/api.php/10223915200931664/search/id/").addConverterFactory(GsonConverterFactory.create()).build();

        datos();
    }

    private void datos(){
        SuperHeroeApiService service = retrofit.create(SuperHeroeApiService.class);
        Call<SuperHeroeRespuesta> superHeroeCall = service.obtenerListaSuperHeroes();

        superHeroeCall.enqueue(new Callback<SuperHeroeRespuesta>() {
            @Override
            public void onResponse(Call<SuperHeroeRespuesta> call, Response<SuperHeroeRespuesta> response) {
                if (response.isSuccessful()){
                SuperHeroeRespuesta superHeroeRespuesta = response.body();
                    ArrayList<SuperHeroe> listaHeroe = superHeroeRespuesta.getResults();
                    if(listaHeroe !=null) {
                        listaHeroesAdapter.adicionarListaHeroes(listaHeroe);
                        listaHeroesAdapter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i = new Intent(MainActivity.this,ActivityDos.class);
                                i.putExtra("nombre", listaHeroe.get(recyclerView.getChildAdapterPosition(view)).getName());
                                i.putExtra("imagen", listaHeroe.get(recyclerView.getChildAdapterPosition(view)).image.getUrl());
                                i.putExtra("fullName", listaHeroe.get(recyclerView.getChildAdapterPosition(view)).biography.getFullName());
                                i.putExtra("alterEgo", listaHeroe.get(recyclerView.getChildAdapterPosition(view)).biography.getAlterEgos());
                                i.putExtra("placeOfB", listaHeroe.get(recyclerView.getChildAdapterPosition(view)).biography.getPlaceOfBirth());
                                i.putExtra("speed", listaHeroe.get(recyclerView.getChildAdapterPosition(view)).powerstats.getSpeed());
                                i.putExtra("intelligence", listaHeroe.get(recyclerView.getChildAdapterPosition(view)).powerstats.getIntelligence());
                                i.putExtra("strength", listaHeroe.get(recyclerView.getChildAdapterPosition(view)).powerstats.getStrength());


                                startActivity(i);
                            }
                        });

                    }
                }else{

                }
            }

            @Override
            public void onFailure(Call<SuperHeroeRespuesta> call, Throwable t) {

            }
        });
    }

}
