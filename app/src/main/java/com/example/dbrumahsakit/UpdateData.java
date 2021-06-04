package com.example.dbrumahsakit;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateData extends AppCompatActivity implements View.OnClickListener{
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
    public void onClick(View v) {

    }

}
