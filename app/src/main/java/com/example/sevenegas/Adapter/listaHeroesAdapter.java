package com.example.sevenegas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sevenegas.Entidades.SuperHeroe;
import com.example.sevenegas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class listaHeroesAdapter extends RecyclerView.Adapter<listaHeroesAdapter.ViewHolder> implements View.OnClickListener {
private final int limite = 20;
private ArrayList<SuperHeroe> datos;
    private Context context;
private View.OnClickListener listener;
public listaHeroesAdapter(Context context){
    this.context=context;
    datos = new ArrayList<>();
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_heroes, null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.asignarDatos(datos.get(position));
    }

    @Override
    public int getItemCount()
    {

        if(datos.size() > limite){
            return limite;
        }
        else
        {
            return datos.size();
        }

    }

    public void adicionarListaHeroes(ArrayList<SuperHeroe> listaHeroe) {
        datos.addAll(listaHeroe);
        notifyDataSetChanged();
    }
public void setOnClickListener(View.OnClickListener listener){
    this.listener=listener;
}
    @Override
    public void onClick(View view) {
if(listener!=null){
    listener.onClick(view);
}
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoImagenView;
        private  TextView nombreHeroe;
        public ViewHolder(View itemView){
            super(itemView);
             fotoImagenView = (ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreHeroe = (TextView) itemView.findViewById(R.id.nombreHeroes);
        }

        public void asignarDatos(SuperHeroe superHeroe) {

            nombreHeroe.setText(superHeroe.getName());
           Picasso.get().load(superHeroe.image.getUrl()).fit().centerCrop().into(fotoImagenView);
        }

    }
}
