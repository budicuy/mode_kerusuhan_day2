package com.example.day2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayActivity extends AppCompatActivity {

    TextView  txtTampilNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display2);

        Intent intent = getIntent();
        String Nama = intent.getStringExtra(MainActivity.KEY_NAMA);

        txtTampilNama = (TextView) findViewById(R.id.txtTampilNama);
        txtTampilNama.setText(Nama);


    }
}