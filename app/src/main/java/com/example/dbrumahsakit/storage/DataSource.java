package com.example.dbrumahsakit.storage;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.example.dbrumahsakit.nodos.pasien;


@Database(entities = {pasien.class}, version = 1)
public abstract class DataSource extends RoomDatabase {
    public abstract DataHelper dataHelper();
    private static volatile DataSource INSTANCE;
    static DataSource getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataSource.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DataSource.class, "pasien")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
