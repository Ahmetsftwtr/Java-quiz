package com.example.mobil_proje;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

class gonderilenveri {
    public static final String Ad = "";
}

    Button btnDegisken;
    EditText isim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        isim = (EditText) findViewById(R.id.isim);
        btnDegisken = (Button) findViewById(R.id.button);
        // btnDegisken isimli elemena tıklanma işlemini gerçekleştiren kod alanı
        btnDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklandığında ne yapmasını gerektiğini belirttik

                if(isim.getText() == null)
                {
                    isim.setHint("Lütfen isim giriniz");
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra(gonderilenveri.Ad, isim.getText().toString());
                    intent.setClass(MainActivity.this, oyun.class);
                    startActivity(intent);
                }

            }

        });
    }
}