package com.geektech.lesson3;

import androidx.activity.result.ActivityResult;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private final int GMAIL = 123;
    private ImageView photo;
    private EditText email, phone, lock;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
        onClick();

    }

    private void onClick() {
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] {email.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT, phone.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, lock.getText().toString());
            startActivity(intent);


        });
    }

    private void iniView() {
        photo = findViewById(R.id.photo);
        email = findViewById(R.id.email1);
        phone = findViewById(R.id.phone);
        lock = findViewById(R.id.lock);
        btn = findViewById(R.id.btn);
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GMAIL && resultCode == RESULT_OK && data != null){

        }
    }*/
}
