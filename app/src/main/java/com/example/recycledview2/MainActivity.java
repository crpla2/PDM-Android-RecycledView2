package com.example.recycledview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyReciclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //preparamos un array con los elementos a mostrar
        ArrayList<String> animalNames= new ArrayList<>();
        animalNames.add("Caballo");
        animalNames.add("Vaca");
        animalNames.add("Oveja");
        animalNames.add("Pollo");
        animalNames.add("Cordero");
        animalNames.add("Conejo");
        animalNames.add("Oca");
        animalNames.add("Gallina");
        animalNames.add("Perro");
        animalNames.add("Gato");

        //preparamos un array con los elementos a mostrar
        ArrayList<String> animalSonidos= new ArrayList<>();
        animalSonidos.add("hiiiiiii");
        animalSonidos.add("muuuuu");
        animalSonidos.add("beeeee");
        animalSonidos.add("pipipi");
        animalSonidos.add("baaaaa");
        animalSonidos.add("ñiñiñi");
        animalSonidos.add("oink");
        animalSonidos.add("cococo");
        animalSonidos.add("guau");
        animalSonidos.add("miau");

        //set up reciclerView
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new MyReciclerAdapter(this,animalNames,animalSonidos);

        //Ponemos una linea de separación entre elementos
        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(recyclerView.getContext(),1);
        recyclerView.addItemDecoration(dividerItemDecoration);

        //añadimos el adaptador a la vista
        recyclerView.setAdapter(adapter);
    }
}