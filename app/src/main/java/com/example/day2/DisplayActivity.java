package com.example.day2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;



public class DisplayActivity extends AppCompatActivity {





    public ArrayList<String> bacaNamaDariText() {
        File file  = new File(getFilesDir(), MainActivity.NAMA_FILE);
        ArrayList<String> listNama = new ArrayList<>();

        if(file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while(line != null) {
                    listNama.add(line);
                    line = br.readLine();
                }

                br.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return listNama;
    }

    ListView list;
    public void memuatList(){
        ArrayList<String> Data = bacaNamaDariText();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, Data);
        list.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);

        list = findViewById(R.id.list_nama);
        memuatList();

    }

    public void hapusSemuaNama() {
        File file = new File(getFilesDir(), MainActivity.NAMA_FILE);
        if(file.exists()) {
            file.delete();
        } else {
            Toast.makeText(this, "File tidak ditemukan", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_hapus) {
            hapusSemuaNama();
            memuatList();
        }
        return true;
    }
}









