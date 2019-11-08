package com.example.PmdmRecyclerViewJava;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Siempre tiene que ir asociado a un ViewHolder que tenemos que crear dentro de la clase Adapter.

// 2º
// Metemos el contenido del Adapter en los diamantes<> e implementamos los metodos
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    // Esta es la etiqueta TAG que tiene todos los objetos
    private static final String TAG = "RecyclerViewAdapter";

    // 3º
    // Añadimos las variables que vamos a usar.
    private Context miContexto;
    private ArrayList<String> misPersonas;
    private ArrayList<String> misAnimales;

    // 4º
    // Generamos constructores y Getters
    public RecyclerViewAdapter(Context miContexto, ArrayList<String> misPersonas, ArrayList<String> misProfesiones){
        this.miContexto = miContexto;
        this.misPersonas = misPersonas;
        this.misAnimales = misProfesiones;
    }

    // 5º
    // Inflamos el layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        ViewHolder holder = new ViewHolder(vista);
        return holder;
    }

    // 6º
    // Este metodo es el que 'pega' los datos de la vista
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // Hay que pasarle el ViewHolder y la posicion en la que estamos ahora mismo
        Log.d(TAG, "OnBindViewHolder called");
        holder.tvNombre.setText(misPersonas.get(position));
        holder.tvAltura.setText(misAnimales.get(position));
        holder.tvAnchura.setText(misAnimales.get(position));
        holder.tvLongitud.setText(misAnimales.get(position));
        holder.tvVelocidad.setText(misAnimales.get(position));

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"oNCLICK: clicked on" + misPersonas.get(position));
                Toast.makeText(miContexto, misPersonas.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return misPersonas.size(); // Devuelve el numero de vistas que vas a tener
    }

    // 1º
    // Creamos en ViewHolder dentro de la clase
    // Dentro del holder hay que poner la vista de cada item

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre, tvAltura, tvAnchura, tvLongitud, tvVelocidad, tvAsesino;
        ImageButton animal;
        LinearLayout parent_layout;

        public ViewHolder(@NonNull View itemView){
            super(itemView); // Super es el que llama al metodo ViewHolder de la clase padre / Es el constructo de la clase donde esta metido
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvAltura = itemView.findViewById(R.id.tvAltura);
            tvAnchura = itemView.findViewsWithText(R.id.tvAnchura);
            parent_layout = itemView.findViewById(R.id.parentLayout);

        }
    }

}
