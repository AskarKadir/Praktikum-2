package com.example.praktikum2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarAct extends AppCompatActivity {

    EditText edtNama,edtAlamat,edtEmail,edtPassword,edtrepass;

    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        fab = findViewById(R.id.tambah);
        edtNama = findViewById(R.id.edNama);
        edtAlamat = findViewById(R.id.edAlamat);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPassword);
        edtrepass = findViewById(R.id.edrepass);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtAlamat.getText().toString().isEmpty() ||
                edtEmail.getText().toString().isEmpty() ||
                edtrepass.getText().toString().isEmpty() ||
                edtPassword.getText().toString().isEmpty()){
                    Snackbar.make(view,"Wajib isi seluruh isi data...!!!!",Snackbar.LENGTH_LONG).show();
                }
                else{

                    if(edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Pendaftaran Berhasil.....!!!!",Toast.LENGTH_LONG).show();;

                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);

                    }else {
                        Snackbar.make(view,"Password dan Repassword harus sama!!!!!",Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}