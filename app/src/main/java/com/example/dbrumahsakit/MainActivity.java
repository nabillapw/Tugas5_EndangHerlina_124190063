package com.example.dbrumahsakit;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.dbrumahsakit.custom.PasienAdapter;
import com.example.dbrumahsakit.nodos.pasien;
import com.example.dbrumahsakit.storage.PasienViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PasienAdapter adapter;
    private PasienViewModel pasienViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list_data);
        adapter = new PasienAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pasienViewModel = ViewModelProviders.of(this).get(PasienViewModel.class);
        pasienViewModel.getAllPasiens().observe(this, new Observer<List<pasien>>() {
            @Override
            public void onChanged(@Nullable final List<pasien> pasiens) {
                // Update the cached copy of the words in the adapter.
                adapter.setPasiens(pasiens);
            }
        });

        FloatingActionButton add = findViewById(R.id.fab);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,AddData.class),12345);
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 12345 && resultCode == RESULT_OK) {
            pasien pasien = data.getParcelableExtra(AddData.EXTRA_REPLY);
            pasienViewModel.insert(pasien);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "ERROR",
                    Toast.LENGTH_LONG).show();
        }
    }





}