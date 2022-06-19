package com.test.a050_009_036_34_uas_ga.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.test.a050_009_036_34_uas_ga.R;

import java.nio.file.Files;
import java.util.HashMap;

public class Tambah_Lokasi extends AppCompatActivity {

   private EditText un,latitude,longitude,notelpon;
   FusedLocationProviderClient client;
   TextView tv_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lokais);

        un = (EditText) findViewById(R.id.ET_USERNAME);
        latitude = (EditText) findViewById(R.id.ET_LATITUDE);
        longitude = (EditText) findViewById(R.id.ET_LONGITUDE);
        notelpon = (EditText) findViewById(R.id.ET_NOTELPON);
        tv_address =(TextView) findViewById(R.id.TV_lokasi);


    }
    //dapat lokasi
    //


    public void BTN_MANUAL(View view) {
        final String username = un.getText().toString().trim();
        final String lt = latitude.getText().toString().trim();
        final String longitudee = longitude.getText().toString().trim();
        final String notelponn = notelpon.getText().toString().trim();

        class TambahRegis extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Tambah_Lokasi.this, "Add","Wait",
                        false,false);
            }
            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String,String> params = new HashMap<>();
                params.put("username",username);
                params.put("latitude",lt);
                params.put("longitude",longitudee);
                params.put("notelpon",notelponn);

                /// 	nama	latitude	longitude
                // username,latitude,longitude

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest("http://192.168.3.104/GIS/register.php",params);
                return res;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

                if (s.equals("berhasil")) {
                    Toast.makeText(Tambah_Lokasi.this,"LOKASI TELAH DIDAPAT", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Tambah_Lokasi.this,"Data tidak falid", Toast.LENGTH_LONG).show();
                }
            }
        }
        TambahRegis ae = new TambahRegis();
        ae.execute();
    }



}