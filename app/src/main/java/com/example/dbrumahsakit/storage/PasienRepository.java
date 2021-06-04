package com.example.dbrumahsakit.storage;

import android.app.Application;
import androidx.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.dbrumahsakit.nodos.pasien;

import java.util.List;


public class PasienRepository {

    private DataHelper dataHelper;
    private LiveData<List<com.example.dbrumahsakit.nodos.pasien>> pasien;

    PasienRepository (Application application){
        DataSource dataSource = DataSource.getDatabase(application);
        dataHelper = dataSource.dataHelper();
        pasien = dataHelper.getAllPasiens();
    }

    LiveData<List<pasien>> getAllPasiens() { return pasien; }
    public void insert (pasien pasien) { new InsertAsyncTask(dataHelper).execute(pasien); }

    public class InsertAsyncTask extends AsyncTask<pasien, Void, Void> {
        private DataHelper dataHelper;
        InsertAsyncTask(DataHelper dataHelper){ this.dataHelper = dataHelper; }
        @Override
        protected Void doInBackground(pasien... pasiens) {
            dataHelper.insert(pasiens[0]);
            return null;
        }
    }
}
