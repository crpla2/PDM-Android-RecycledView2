package com.example.recycledview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyReciclerAdapter extends RecyclerView.Adapter<MyReciclerAdapter.ViewHolder>{
    private List<String> mName;
    private List<String> MSound;
    private LayoutInflater mInflater;
   // private ItemClickListener mClicklistener;

    /**
     * Constructor
     * @param context
     * @param data
     */
    MyReciclerAdapter(Context context, List<String>data,List<String >sound){
        mInflater=LayoutInflater.from(context);
        mName=data;
        MSound= sound;

    }
    /**
     * Inflar cada fila del xml cuando sea necesario
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyReciclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.reciclerviewrow,parent,false);
        return new ViewHolder(view);
    }

    /**
     * Enlaza los datos con el viewholder correspondiente
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyReciclerAdapter.ViewHolder holder, int position) {
        holder.setTextName(mName.get(position));
        holder.setTextSound(MSound.get(position));

    }

    /**
     * devuelve cuantos elementos hay
     * @return
     */
    @Override
    public int getItemCount() {
        return mName.size();
    }

    /**** PARA EL LISTENER ****/

/*
    //La actividad padre implementa este metodo para responder a los elementos de clic
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClicklistener=itemClickListener;
    }
    //Permite capturar los eventos del clic
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
*/
    //METODOS AUXILIARES
    String getItem(int pos){
        return mName.get(pos);
    }

    /**
     * Esta clase corresponde a cada fila
     * almacena y recicla las vistas según salen de la pantalla
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textViewName;
        private TextView textViewSound;
        private TextView textViewNumero;
        private Button botonsumar,botonrestar;
        private int num =0;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.textViewNombre);
            textViewSound=itemView.findViewById(R.id.textViewSonido);
            textViewNumero=itemView.findViewById(R.id.textViewNumero);
            botonsumar=itemView.findViewById(R.id.sumar);
            botonrestar=itemView.findViewById(R.id.restar);
            botonrestar.setOnClickListener(this);
            botonsumar.setOnClickListener(this);
        }

        public void setTextName(String s) {
            textViewName.setText(s);
        }

        public String getMyTextName()
        {
            return textViewName.getText().toString();
        }
        public void setTextSound(String s) {
            textViewSound.setText(s);
        }

        public String getMyTextSound()
        {
            return textViewSound.getText().toString();
        }
        public void setTextNumero(String s) {
            textViewNumero.setText(s);
        }

        public String getMyTextNumero()
        {
            return textViewNumero.getText().toString();
        }
        @Override
        public void onClick(View view) {
            if(view.getId()==botonrestar.getId()){
                num--;
            }
            else{
                num++;
            }
            Toast.makeText(botonrestar.getContext(),getMyTextSound(),Toast.LENGTH_SHORT).show();
            textViewNumero.setText(String.valueOf(num));
        }
    }
}
