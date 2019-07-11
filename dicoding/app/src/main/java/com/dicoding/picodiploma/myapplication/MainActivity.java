package com.dicoding.picodiploma.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etTinggi, etLebar, etPanjang;

    TextView tvHasil;
    Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPanjang = findViewById(R.id.et_panjang);
        etLebar = findViewById(R.id.et_lebar);
        etTinggi = findViewById(R.id.et_tinggi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung){
            String inputPanjang = etPanjang.getText().toString().trim();
            String inputLebar = etLebar.getText().toString().trim();
            String inputTinggi = etTinggi.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputPanjang)){
                isEmptyFields = true;
                etPanjang.setError("Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(inputLebar)){
                isEmptyFields = true;
                etLebar.setError("Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(inputTinggi)){
                isEmptyFields = true;
                etTinggi.setError("Tidak Boleh Kosong");
            }

            Double panjang = toDouble(inputPanjang);
            Double lebar = toDouble(inputLebar);
            Double tinggi = toDouble(inputTinggi);

            if (panjang== null) {
                isInvalidDouble = true;
                etPanjang.setError("masukkan angka yang valid");
            }
            if (lebar == null) {
                isInvalidDouble = true;
                etLebar.setError("masukkan angka yang valid");
            }
            if (tinggi == null) {
                isInvalidDouble = true;
                etTinggi.setError("masukkan angka yang valid");
            }

            if(!isEmptyFields && !isInvalidDouble){
                Double volume = panjang*lebar*tinggi;
                if(volume % 1 == 0){
                    Integer hasil = (int) Math.round(volume);
                    tvHasil.setText(String.valueOf(hasil));
                }
                else{
                    tvHasil.setText(String.valueOf(volume));
                }

            }

        }
    }

    private Double toDouble(String str){
        try{
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
