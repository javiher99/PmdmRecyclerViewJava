package com.example.PmdmRecyclerViewJava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> lasPersonas = new ArrayList<>();
    private ArrayList<String> lasProfesiones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarDatos();
    }

    private void cargarDatos() {
        lasPersonas.add ("Ana Garcia");
        lasProfesiones.add("Ingeniera Meanica");

        lasPersonas.add("Javier Hernandez");
        lasProfesiones.add("Policia");

        lasPersonas.add("Gimena Gutierrez");
        lasProfesiones.add("Sin Techo");

        lasPersonas.add("Bilbo Bolson");
        lasProfesiones.add("Portador de anillo");

        lasPersonas.add("Andwin Wint");
        lasProfesiones.add("Rey de la Alianza");

        lasPersonas.add("Laura Ruiz");
        lasProfesiones.add("Extintor de mano");

        initRecyclerView();
    }

    private void initRecyclerView (){
        RecyclerView miRecycler = findViewById(R.id.rvRecycler);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, lasPersonas, lasProfesiones);
        miRecycler.setAdapter(adapter);
        miRecycler.setLayoutManager(new LinearLayoutManager((this)));

    }
}
