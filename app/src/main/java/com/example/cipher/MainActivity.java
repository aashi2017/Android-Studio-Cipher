package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.cipher.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button caesar,affine,mInverse,rsaKey,mainMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caesar=findViewById(R.id.caesar);
        affine=findViewById(R.id.affine);
        mInverse=findViewById(R.id.mInverse);
        rsaKey=findViewById(R.id.rsaKey);



        caesar.setOnClickListener(this);
        affine.setOnClickListener(this);
        mInverse.setOnClickListener(this);
        rsaKey.setOnClickListener(this);
        mainMenu=findViewById(R.id.mainMenu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.caesar:
                Intent intent = new Intent(MainActivity.this, caesar_cipher.class);
                startActivity(intent);
                setContentView(R.layout.activity_caesar_cipher);

                break;
            case R.id.affine:
                Intent intent1 = new Intent(MainActivity.this, Affine.class);
                startActivity(intent1);
                setContentView(R.layout.activity_affine);
                break;
            case R.id.mInverse:
                Intent intent2 = new Intent(MainActivity.this, Multi.class);
                startActivity(intent2);
                setContentView(R.layout.activity_affine);
                break;
            case R.id.rsaKey:
                Intent intent3 = new Intent(MainActivity.this, Rsa.class);
                startActivity(intent3);
                setContentView(R.layout.activity_affine);
                break;

        }
    }
}
