package com.example.day2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    EditText textInputNama;
    Button btnTampilkan;
    public static String KEY_NAMA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputNama = findViewById(R.id.txtNama);
        btnTampilkan = findViewById(R.id.btnTampilkan);

        btnTampilkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DisplayActivity.class);
                i.putExtra(KEY_NAMA, textInputNama.getText().toString());
                startActivity(i);
            }
        });
    }
}