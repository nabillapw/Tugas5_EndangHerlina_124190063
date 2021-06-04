package com.example.dbrumahsakit.storage;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import androidx.lifecycle.AndroidViewModel;

import com.example.dbrumahsakit.nodos.pasien;

import java.util.List;

public class PasienViewModel extends AndroidViewModel {
    private PasienRepository repository;
    private LiveData<List<pasien>> pasien;

    public PasienViewModel(@NonNull Application application) {
        super(application);
        repository = new PasienRepository(application);
        pasien = repository.getAllPasiens();
    }

    public LiveData<List<pasien>> getAllPasiens() { return pasien; }
    public void insert(pasien pasien) { repository.insert(pasien); }


}