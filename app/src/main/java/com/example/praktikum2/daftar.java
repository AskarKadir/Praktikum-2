package com.example.praktikum2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class daftar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        EditText Nama,Email,Pass,Pass1;
        Button BDaftar;
        BDaftar = findViewById(R.id.BDaftar);
        Nama = findViewById(R.id.RNama);
        Email = findViewById(R.id.REmail);
        Pass = findViewById(R.id.FRPassword);
        Pass1 = findViewById(R.id.SRPassword2);

        BDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, email, rpas1, rpas2;
                nama = Nama.getText().toString();
                email = Email.getText().toString();
                rpas1 = Pass.getText().toString();
                rpas2 = Pass1.getText().toString();

                if(nama.isEmpty()){
                    showErorNama(Nama,"Nama Tidak Boleh Kosong");
                }else if(email.isEmpty()){
                    showErorEmail(Email,"Email Tidak Boleh Kosong");
                }else if(!rpas2.equals(rpas1)){
                    showErorPass(Pass1,"Password Tidak Sama");
                }else{
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    Toast t = Toast.makeText(getApplicationContext(),"Akun Berhasil di Buat",Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }

    private void showErorPass(EditText pass1, String password_tidak_sama) {
        pass1.setError(password_tidak_sama);
    }

    private void showErorNama(EditText isinama, String m) {
        isinama.setError(m);
    }
    private void showErorEmail(EditText isiemail, String m) {
        isiemail.setError(m);
    }
}