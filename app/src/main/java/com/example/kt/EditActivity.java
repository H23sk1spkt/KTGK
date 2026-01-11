package com.example.kt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
    EditText edtHoten, edtNgaysinh, edtTuoi;
    Button btnHuy, btnCapnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ⚠️ Dùng đúng layout của EditActivity, không phải activity_main
        setContentView(R.layout.activity_edit);

        // Ánh xạ view
        edtHoten = findViewById(R.id.edtHoTen);
        edtNgaysinh = findViewById(R.id.edtNgaysinh);
        edtTuoi = findViewById(R.id.edtTuoi);
        btnHuy = findViewById(R.id.btnHuy);
        btnCapnhap = findViewById(R.id.btnCapnhap);

        // Nhận dữ liệu từ MainActivity
        Intent intent = getIntent();
        edtHoten.setText(intent.getStringExtra("hoTen"));
        edtNgaysinh.setText(intent.getStringExtra("ngaySinh"));
        edtTuoi.setText(intent.getStringExtra("Tuoi"));

        // Nút cập nhật
        btnCapnhap.setOnClickListener(v -> {
            Intent result = new Intent();
            result.putExtra("hoTen", edtHoten.getText().toString().trim());
            result.putExtra("ngaySinh", edtNgaysinh.getText().toString().trim());
            result.putExtra("Tuoi", edtTuoi.getText().toString().trim());
            setResult(RESULT_OK, result);
            finish(); // Trả về MainActivity
        });

        // Nút hủy
        btnHuy.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
