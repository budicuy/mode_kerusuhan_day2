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
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.BreakIterator;


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
                startActivity(i);
            }
        });

        Button btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanNamaText(textInputNama.getText().toString());
            }
        });

    }
    public static String NAMA_FILE = "data_nama.txt";
    public void simpanNamaText(String nama) {
        File file = new File(getFilesDir(), NAMA_FILE);

        FileOutputStream outputStream = null;

        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(outputStream);
            myOutWriter.append(nama + "\n");
            outputStream.flush();
            myOutWriter.close();
            outputStream.close();

            Toast.makeText(this, "Nama berhasil disimpan", Toast.LENGTH_SHORT).show();
            textInputNama.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}