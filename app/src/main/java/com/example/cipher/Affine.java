package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Affine extends AppCompatActivity implements View.OnClickListener {
    private Button decryptA,encryptA,mainMenuA;
    private EditText msgA,key1,key2;
    private TextView resA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affine);
        decryptA=findViewById(R.id.decryptA);
        encryptA=findViewById(R.id.encryptA);
        mainMenuA=findViewById(R.id.mainMenuA);
        resA=findViewById(R.id.resA);
        msgA=findViewById(R.id.msgA);
        key1=findViewById(R.id.key1);
        key2=findViewById(R.id.key2);

        decryptA.setOnClickListener(this);
        encryptA.setOnClickListener(this);
        mainMenuA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.decryptA:
                String plain1=msgA.getText().toString();
                resA.setText(decryptionMessage(plain1));
                break;
            case R.id.encryptA:
                String plain= msgA.getText().toString();

                resA.setText(mainCod(plain));
                break;
            case R.id.mainMenuA:
                Intent intent = new Intent(Affine.this, MainActivity.class);
                startActivity(intent);
                setContentView(R.layout.activity_main);
                break;
        }
    }

    public String mainCod(String plainT){

        int k1 = Integer.parseInt(key1.getText().toString());
        int k2 = Integer.parseInt(key2.getText().toString());
        String cipher="";

        for (int i = 0; i < plainT.length(); i++)
        {
            cipher = cipher + (char) ((((k1 * plainT.charAt(i)) + k2) % 26) + 65);
        }
        return cipher;



    }
    public  String decryptionMessage(String CTxt)
    {
        String Msg = "";
        int k1 = Integer.parseInt(key1.getText().toString());
        int k2 = Integer.parseInt(key2.getText().toString());
        int a_inv = 0;
        int flag = 0;
        for (int i = 0; i < 26; i++)
        {
            flag = (k1 * i) % 26;
            if (flag == 1)
            {
                a_inv = i;
                System.out.println(i);
            }
        }
        for (int i = 0; i < CTxt.length(); i++)
        {
            Msg = Msg + (char) (((a_inv * ((CTxt.charAt(i) - k2)) % 26)) + 65);
        }
        return Msg;
    }
}
