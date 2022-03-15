package com.example.praktikum2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //deklarasi variabel
    Button Blogin;

    EditText emailinput, passwordinput;

    String user, passwd;



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //kondisi
        if (item.getItemId() == R.id.mnDaftar){
            Intent i = new Intent(getApplicationContext(),DaftarAct.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //menghubungkan button pada layout
        Blogin = findViewById(R.id.buttonsign);

        emailinput = findViewById(R.id.email);

        passwordinput = findViewById(R.id.passw);

        //membuat fungsi onclick pada button
        Blogin.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  //save input user pada email ke variabel user
                  user = emailinput.getText().toString();

                  //save passwd input user
                  passwd = passwordinput.getText().toString();

                  if (user.equals("1") && passwd.equals("1")) {
                      Bundle b = new Bundle();
                      //key parsing data dmasukkan kedalam bundle
                      b.putString("a", user.trim());
                      b.putString("b", passwd.trim());

                      //membuat objek untuk pindah halaman sehingga dapat memanggail java class yang baru
                      Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                      //memasukkan bundle ke daslam intent
                      i.putExtras(b);
                      //berpindah ke halaman lain
                      startActivity(i);

                      Toast t = Toast.makeText(getApplicationContext(),
                              "Anda Berhasil Login", Toast.LENGTH_LONG);
                      t.show();

                  } else if (user.equals("admin@corp.id") && !passwd.equals("SAdmin")) {
                      Toast t = Toast.makeText(getApplicationContext(),
                              "Password Anda Salah", Toast.LENGTH_LONG);
                      t.show();
                  } else if (!user.equals("admin@copr.id") && passwd.equals("SAdmin")) {
                      Toast t = Toast.makeText(getApplicationContext(),
                              "Email Anda salah", Toast.LENGTH_LONG);
                      t.show();
                  } else {
                      Toast t = Toast.makeText(getApplicationContext(),
                              "Email dan Password Anda Salah", Toast.LENGTH_LONG);
                      t.show();

                  }
              }
          }
        );
    }
}
