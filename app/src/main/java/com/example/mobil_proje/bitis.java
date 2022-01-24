package com.example.mobil_proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class bitis extends AppCompatActivity {

    TextView gelenad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitis);


        gelenad = (TextView) findViewById(R.id.oyuncuad1);
        gelenad.setText(getIntent().getExtras().getString(MainActivity.gonderilenveri.Ad));

        TextView sonucskor = findViewById(R.id.sonucskor);
        TextView toplamskor = findViewById(R.id.toplamskor);

        int skor = getIntent().getIntExtra("Dogru_cevap_sayısı", 0);

        SharedPreferences sharedPreferences = getSharedPreferences("Soru_verileri", Context.MODE_PRIVATE);
        int toplamskorr = sharedPreferences.getInt("TOPLAM_SKOR", 0);
        toplamskorr += skor;

        sonucskor.setText(skor + " / 10");
        toplamskor.setText("Toplam Skorunuz : " + toplamskorr);

        // Update total score.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("TOPLAM_SKOR", toplamskorr);
        editor.apply();
    }

    public void tekraroyna(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }

}