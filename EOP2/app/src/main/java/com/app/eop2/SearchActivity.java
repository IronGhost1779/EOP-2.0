package com.app.eop2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.app.eop2.adapter.AdapterProductos;
import com.app.eop2.pojo.Producto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity {

    DatabaseReference ref;
    ArrayList<Producto> list;
    RecyclerView rv;
    SearchView searchView;
    AdapterProductos adapter;

    LinearLayoutManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ref = FirebaseDatabase.getInstance().getReference().child("Productos");
        rv = findViewById(R.id.rv);
        searchView = findViewById(R.id.search);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        list = new ArrayList<>();
        adapter = new AdapterProductos(list);
        rv.setAdapter(adapter);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot snapshot1 : snapshot.getChildren()){
                        Producto ms = snapshot.getValue(Producto.class);
                        list.add(ms);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                buscar(s);
                return true;
            }
        });
    }

    private void buscar(String s) {
        ArrayList<Producto> milista = new ArrayList<>();
        for (Producto obj : list){
            if(obj.getPasillo().toLowerCase().contains(s.toLowerCase())){
                milista.add(obj);
            }

        }
        AdapterProductos adapter = new AdapterProductos(milista);
        rv.setAdapter(adapter);
    }
}