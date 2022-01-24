package com.example.mobil_proje;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class oyun extends AppCompatActivity {
    TextView gelenad;




    private String dogrucevap;
    private TextView sorubaslık;
    private int sorusayı = 1;
    private int dogrucevapsayısı = 0;
    static final private int max_soru_sayı = 10;




    Button BUTTONa,BUTTONb,BUTTONc,BUTTONd;
    TextView sorulabel;
    TextView sil1;

    ArrayList<ArrayList<String>> sorulist = new ArrayList<>();
    String Sorular[][] =
                            {
        // {"Ülke", "Doğru cevap", "Şık1", "Şık2", "Şık3"}
        {"Fatih Sultan Mehmet’in babası kimdir?", "II. Murat", "Yıldırım Beyazıt", "I. Mehmet", "Kanuni Sultan süleyman"},
        {"Hangi yabancı futbolcu Fenerbahçe forması giymiştir?", "Schumacher", "Prekazi", "Simoviç", "Ronaldo"},
        {"Magna Carta hangi ülkenin kralıyla yapılmış bir sözleşmedir?", "İngiltere", "Fransa", "İspanya", "Türkiye"},
        {"Hangisi periyodik tabloda bulunan bir element değildir?", "Su", "Azot", "Oksijen", "Hidrojen"},
        {"Hangisi bir doğal sayıdır?", "0", "2,5", "-1", "2"},
        {"Hangisi tarihteki Türk devletlerinden biri değildir?", "Emevi Devleti", "Avar Kağanlığı", "Hun İmparatorluğu", "Roma imparatorluğu"},
        {"Galatasaray hangi yıl UEFA kupasını almıştır?", "2000", "2001", "2002", "2005"},
        {"Kıbrıs Barış harekatı hangi tarihte gerçekleşmiştir?", "1974", "1972", "1970", "1969"},
        {"Hangi ülke Asya kıtasındadır?", "Singapur", "Peru", "Madagaskar", "Santiago"},
        {"ABD başkanlarından John Fitzgerald Kennedy’e suikast düzenleyerek öldüren kimdir?", "Lee Harvey Oswald", "Clay Shaw", "Jack Ruby", "Lee bruce"},
        {"Aşağıdaki hangi Anadolu takımı Türkiye Süper Liginde şampiyon olmuştur?", "Bursaspor", "Kocaelispor", "Eskişehirspor", "Diyarbekirspor"},
        {"Hangisi Kanuni Sultan Süleyman’ın eşidir?", "Hürrem Sultan", "Kösem Sultan", "Safiye Sultan", "Mahide Sultan"},
        {"Hangisi bir hücrede bulunan organeldir?", "Lizozom", "DNA", "RNA", "Kromozom"},
        {"Tarihçilerin Kutbu olarak bilinen dünyaca ünlü tarihçimiz kimdir?", "Halil İnalcık", "İlber Ortaylı", "Mehmet Fuat Köprülü", "Aziz Sancar"},
        {"Cristiano Ronaldo daha önce hangi futbol takımında oynamıştır?", "Manchester United", "Bayern Munich", "Liverpool", "Real madrid"}
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);
        sorubaslık = findViewById(R.id.soru);
        sorulabel = findViewById(R.id.soruno);


        gelenad = (TextView) findViewById(R.id.oyuncuad);
        gelenad.setText(getIntent().getExtras().getString(MainActivity.gonderilenveri.Ad));

        BUTTONa = (Button) findViewById(R.id.asıkkı);
        BUTTONb = (Button) findViewById(R.id.bsıkkı);
        BUTTONc = (Button) findViewById(R.id.csıkkı);
        BUTTONd = (Button) findViewById(R.id.dsıkkı);



        for (int i = 0; i < Sorular.length; i++) {

            // Dizileri hazırlayalım
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(Sorular[i][0]); // Soru
            tmpArray.add(Sorular[i][1]); // Doğru Cevap
            tmpArray.add(Sorular[i][2]); // Şık1
            tmpArray.add(Sorular[i][3]); // Şık2
            tmpArray.add(Sorular[i][4]); // Şık3

            // Sorulara tmpArray ekleyelim
            sorulist.add(tmpArray);
        }
        sonrakisoru();

    }


    public void sonrakisoru() {



        // Soru Sayısını güncelleyelim
        sorulabel.setText(""+sorusayı);
        // 1 ile Soru sayısı kadar olan random random bir sayı üretelim
        Random random = new Random();
        int randomNum = random.nextInt(sorulist.size());

        // Random bir soru seçelim
        ArrayList<String> sorurandom = sorulist.get(randomNum);

        // Soruyu ve cevabı ayarlayalım
        // Dizi formatı: {"Sorular", "Doğru Cevap", "Şık1", "Şık2", "Şık3"}
        sorubaslık.setText(sorurandom.get(0));
        dogrucevap = sorurandom.get(1);

        // Soruyu sorulardan kaldıralım
        sorurandom.remove(0);
        Collections.shuffle(sorurandom);

        // Seçimleri ayarlayalım
        BUTTONa.setText(sorurandom.get(0));
        BUTTONb.setText(sorurandom.get(1));
        BUTTONc.setText(sorurandom.get(2));
        BUTTONd.setText(sorurandom.get(3));

        // Soruyu Sorulistesinden kaldıralım
        sorulist.remove(randomNum);


    }


public void kontrol(View view) {

        // Düğmeye basınca
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

    String alertTitle = null;


        if (btnText.equals(dogrucevap)) {


            alertTitle = "Doğru Cevap";
            dogrucevapsayısı++;

        } else {

            alertTitle = "Yanlış Cevap";

        }



    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(alertTitle);
    builder.setMessage("Cevap : " + dogrucevap);
    builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (sorusayı == max_soru_sayı) {
                Intent intent = new Intent(getApplicationContext(), bitis.class);
                intent.putExtra("Dogru_cevap_sayısı", dogrucevapsayısı);
                intent.putExtra(MainActivity.gonderilenveri.Ad, gelenad.getText().toString());
                startActivity(intent);

            } else {
                sorusayı++;
                sonrakisoru();
                sil1 = (TextView) findViewById(R.id.textView6);


                sil1.setText("İyi oyunlar");
            }
        }
    });
    builder.setCancelable(false);
    builder.show();
}


        }





