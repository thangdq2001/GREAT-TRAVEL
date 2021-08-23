package com.example.duan1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1.Dao.UserDao;

public class LoginAcivity extends AppCompatActivity {
EditText username,password;
Button dangNhap,AdminDangNhap,dangKi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acivity);
        username = findViewById(R.id.edtUsernameDangNhap);
        password = findViewById(R.id.edtPasswordDangNhap);
        dangNhap = findViewById(R.id.btnDangNhap);
        dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = username.getText().toString();
                String pass = password.getText().toString();
                UserDao.readData(tk,pass,LoginAcivity.this);

            }
        });
        AdminDangNhap =findViewById(R.id.btnDangNhapAdmin);
        AdminDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tk = username.getText().toString();
                String pass = password.getText().toString();
                UserDao.readDataAdmin(tk,pass,LoginAcivity.this);
            }
        });
        dangKi = findViewById(R.id.btnDangKi);
        dangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogDangKi dialogDangKi = new DialogDangKi();
                dialogDangKi.show(getSupportFragmentManager(),"DialogDangKi");
            }
        });

    }

}