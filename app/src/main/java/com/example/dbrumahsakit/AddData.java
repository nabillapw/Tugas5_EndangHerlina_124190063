package com.example.dbrumahsakit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.dbrumahsakit.nodos.pasien;


public class AddData extends AppCompatActivity implements View.OnClickListener{

    public static final String EXTRA_REPLY = "dbrumahsakit.REPLY";
    EditText nama,tglmasuk,tglkeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        findViewById(R.id.button).setOnClickListener(this);
        nama = findViewById(R.id.edittext1);
        tglmasuk = findViewById(R.id.edittext2);
        tglkeluar = findViewById(R.id.edittext3);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button){
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(nama.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String namaN = nama.getText().toString();
                String  tglmasukN = tglmasuk.getText().toString();
                String  tglkeluarN = tglkeluar.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, new pasien(0,namaN,tglmasukN,tglkeluarN));
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        }
    }


}
