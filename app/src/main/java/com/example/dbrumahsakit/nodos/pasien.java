package com.example.dbrumahsakit.nodos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;


@Entity(tableName = "pasien")
public class pasien implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "tglmasuk")
    private String tglmasuk;

    @ColumnInfo(name = "tglkeluar")
    private String tglkeluar;


    public pasien(int id, String nama, String tglmasuk, String tglkeluar) {
        this.id = id;
        this.nama = nama;
        this.tglmasuk = tglmasuk;
        this.tglkeluar = tglkeluar;
    }

    protected pasien(Parcel in) {
        id = in.readInt();
        nama = in.readString();
        tglmasuk = in.readString();
        tglkeluar = in.readString();
    }

    public static final Creator<pasien> CREATOR = new Creator<pasien>() {
        @Override
        public pasien createFromParcel(Parcel in) {
            return new pasien( in );
        }

        @Override
        public pasien[] newArray(int size) {
            return new pasien[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getTglmasuk() {
        return tglmasuk;
    }

    public String getTglkeluar() {
        return tglkeluar;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt( id );
        parcel.writeString( nama );
        parcel.writeString( tglmasuk );
        parcel.writeString( tglkeluar );

    }
}
