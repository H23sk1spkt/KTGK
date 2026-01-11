package com.example.kt;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText edtHoten , edtNgaysinh, edtTuoi;
    Button btnLuu;
    TextView txtKetqua;
    private static final int REQUEST_EDIT=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHoten=findViewById(R.id.edtHoTen);
        edtNgaysinh=findViewById(R.id.edtNgaysinh);
        edtTuoi=findViewById(R.id.edtTuoi);
        btnLuu=findViewById(R.id.btnLuu);
        txtKetqua=findViewById(R.id.txtKetqua);
        btnLuu.setOnClickListener(v ->{
            String hoTen=edtHoten.getText().toString().trim();
            String ngaySinh=edtNgaysinh.getText().toString().trim();
            String Tuoi=edtTuoi.getText().toString().trim();
            if(!hoTen.isEmpty() || !ngaySinh.isEmpty() || !Tuoi.isEmpty() ){
                Toast.makeText(this,"vui long nhap  du thong tin",Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_EDIT && resultCode == RESULT_OK){
            String hoten=data.getStringExtra("hoTen");
            String ngaySinh=data.getStringExtra("ngaySinh");
            String Tuoi=data.getStringExtra("Tuoi");
            txtKetqua.setText("Ho ten"+hoten+ "\nNgay sinh" +ngaySinh+"\nTuoi" +Tuoi);
        }
    }
}