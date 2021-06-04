package com.example.dbrumahsakit.storage;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dbrumahsakit.nodos.pasien;

import java.util.List;


@Dao
public interface DataHelper {
    @Insert
    void insert(pasien pasien);

    @Update
    void update(pasien pasien);

    @Query("DELETE FROM pasien")
    void deleteAll();

    @Query("SELECT * from pasien ORDER BY id ASC")
    LiveData<List<pasien>> getAllPasiens();
}
