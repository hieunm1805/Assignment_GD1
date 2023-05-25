package com.hieunguyen.fpoly.assignment_gd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class activity_login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);
        CheckBox remember = findViewById(R.id.chk_remember);

        Bundle data = getIntent().getExtras();

        edtUsername.setText(data.getString("username"));
        edtPassword.setText(data.getString("password"));

        Button btnDangnhap = findViewById(R.id.btn_dangNhap);
        Button btnBack = findViewById(R.id.btn_dangKy);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent data = new Intent();
                data.putExtra("number", 18);

                setResult(RESULT_OK, data);
                onBackPressed();
            }
        });

        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (username.equals("") && password.equals("")) {
                    Toast.makeText(activity_login.this, "Không được để trống tài khoản, mật khẩu", Toast.LENGTH_SHORT).show();
                } else if (username.equals("")) {
                    Toast.makeText(activity_login.this, "Không được để trống tài khoản", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(activity_login.this, "Không được để trống mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), activity_QLNS.class);
                    startActivity(intent);
                }
            }
        });

    }

}
