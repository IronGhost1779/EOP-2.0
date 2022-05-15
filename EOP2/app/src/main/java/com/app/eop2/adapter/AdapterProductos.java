package com.app.eop2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.eop2.R;
import com.app.eop2.pojo.Producto;

import java.util.List;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.viewholderproductos> {

    List<Producto> productoList;

    public AdapterProductos(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @NonNull
    @Override
    public viewholderproductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_productos,parent, false);
        viewholderproductos holder = new viewholderproductos(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholderproductos holder, int position) {

        Producto ms = productoList.get(position);

        holder.tv_nombre.setText((ms.getNombre()));
        holder.tv_pasillo.setText((ms.getNombre()));
        holder.tv_mostrador.setText((ms.getNombre()));

    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class viewholderproductos extends RecyclerView.ViewHolder {

        TextView tv_nombre, tv_pasillo, tv_mostrador;

        public viewholderproductos(@NonNull View itemView) {
            super(itemView);
            tv_nombre=itemView.findViewById(R.id.tv_nombre);
            tv_pasillo=itemView.findViewById(R.id.tv_pasillo);
            tv_mostrador=itemView.findViewById(R.id.tv_mostrador);
        }
    }
}
