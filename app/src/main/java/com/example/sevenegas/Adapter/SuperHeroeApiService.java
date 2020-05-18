package com.example.sevenegas.Adapter;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SuperHeroeApiService {

@GET("powerstats")
   Call<SuperHeroeRespuesta> obtenerListaSuperHeroes();
}
